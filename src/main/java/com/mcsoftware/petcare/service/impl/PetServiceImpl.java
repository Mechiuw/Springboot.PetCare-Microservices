package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import com.mcsoftware.petcare.repository.PetRepository;
import com.mcsoftware.petcare.repository.ServiceProviderRepository;
import com.mcsoftware.petcare.repository.ShelterRepository;
import com.mcsoftware.petcare.service.interfaces.PetService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final BuilderConverter builderConverter;

    @Override
    public Pet petFinder(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found any pet with id: %s",id)));
    }

    @Override
    public Shelter shelterFinder(String id) {
        return shelterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found any shelter with id: %s",id)));
    }

    @Override
    public ServiceProvider serviceProviderFinder(String id) {
        return serviceProviderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found any service provider with id: %s",id)));
    }

    @Override
    public PetRequest petValidator(PetRequest petRequest) {
        if(petRequest != null) {
            if(petRequest.getAge().isEmpty()){
                throw new NoSuchElementException("age can't be null");
            }if(petRequest.getBreed().isEmpty()){
                throw new NoSuchElementException("breed can't be null");
            }if(petRequest.getName().isEmpty()){
                throw new NoSuchElementException("name can't be null");
            }if(petRequest.getServiceProviderId().isEmpty()){
                throw new NoSuchElementException("service provider can't be null");
            }if(petRequest.getMedicalConditions().isEmpty()){
                throw new NoSuchElementException("medical conditions can't be null");
            }if(petRequest.getShelterAdoptId().isEmpty()){
                throw new NoSuchElementException("shelter can't be null");
            }
        } else {
            throw new IllegalArgumentException("pet request can't be null");
        }

        return petRequest;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PetResponse create(PetRequest petRequest) {
        try {
            Shelter shelter = shelterFinder(petRequest.getShelterAdoptId());
            PetRequest validatedRequest = petValidator(petRequest);
            ServiceProvider serviceProvider = serviceProviderFinder(validatedRequest.getServiceProviderId());
            Pet pet = builderConverter.petBuilderConvert(validatedRequest,shelter,serviceProvider);

            assert pet != null : "pet forbidden to be null";
            Pet newPet = petRepository.save(pet);
            return builderConverter.petResponseBuilderConvert(newPet,validatedRequest);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public PetResponse update(String id, PetRequest petRequest) {
        try {
            Pet foundPet = petFinder(id);
            PetRequest validatedRequest = petValidator(petRequest);

            foundPet.setName(validatedRequest.getName());
            foundPet.setAnimalType(validatedRequest.getAnimalType());
            foundPet.setBreed(validatedRequest.getBreed());
            foundPet.setAge(validatedRequest.getAge());
            foundPet.setMedicalConditions(validatedRequest.getMedicalConditions());

            Pet newPet = petRepository.saveAndFlush(foundPet);
            return builderConverter.petResponseBuilderConvert(newPet, validatedRequest);
        } catch (EntityNotFoundException e){
            throw new RuntimeException(String.format("Entity not found: %s",e.getMessage()));
        } catch (ValidationException e){
            throw new RuntimeException(String.format("Validation exception caught: %s",e.getMessage()));
        } catch (Exception e){
            throw new RuntimeException(String.format("Failed to execute: %s",e.getMessage()));
        }
    }

    @Override
    public void delete(String id) {
        try {
            petRepository.delete(petFinder(id));
        } catch (EntityNotFoundException e){
            throw new RuntimeException(String.format("Entity not found: %s",e.getMessage()));
        } catch (Exception e){
            throw new RuntimeException(String.format("Failed to execute: %s",e.getMessage()));
        }
    }

    @Override
    public PetResponse getById(String id) {
        try {
            Pet findPet = petFinder(id);
            return builderConverter.petResponseBuilder(findPet);
        } catch (EntityNotFoundException e){
            throw new RuntimeException(String.format("Entity not found: %s",e.getMessage()));
        } catch (Exception e){
            throw new RuntimeException(String.format("Failed to execute: %s",e.getMessage()));
        }
    }

    @Override
    public List<Pet> getAll() {
        try {
            List<Pet> pets = petRepository.findAll();
            if (pets.isEmpty()){
                throw new RuntimeException("Pet list is empty");
            }
            return pets;
        } catch (EntityNotFoundException e){
            throw new RuntimeException(String.format("Entity not found: %s",e.getMessage()));
        } catch (Exception e){
            throw new RuntimeException(String.format("Failed to execute: %s",e.getMessage()));
        }
    }

    @Override
    public PetResponse petBoarding(WildAnimal wildAnimal) {
        if(wildAnimal.getVaccinatePointId() != null){

        } else {
            throw new IllegalArgumentException("failed to board caused due wild animal still not vaccinated");
        }

        return null;
    }
}
