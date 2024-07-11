package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.repository.PetRepository;
import com.mcsoftware.petcare.repository.ShelterRepository;
import com.mcsoftware.petcare.service.interfaces.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;

    @Override
    public Shelter shelterFinder(String id) {
        return shelterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found any shelter with id: %s",id)));
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
    public PetResponse create(PetRequest petRequest) {
        Shelter shelter = shelterFinder(petRequest.getShelterAdoptId());
        PetRequest validatedRequest = petValidator(petRequest);

        Pet pet = Pet.builder()
                .name(validatedRequest.getName())
                .animalType(validatedRequest.getAnimalType())
                .breed(validatedRequest.getBreed())
                .age(validatedRequest.getAge())
                .medicalConditions(validatedRequest.getMedicalConditions())
                .shelterAdoptId(shelter)


                .build();
        return null;
    }

    @Override
    public PetResponse update(String id, PetRequest petRequest) {
        return null;
    }

    @Override
    public PetResponse delete(String id) {
        return null;
    }

    @Override
    public PetResponse getById(String id) {
        return null;
    }

    @Override
    public PetResponse getAll() {
        return null;
    }
}
