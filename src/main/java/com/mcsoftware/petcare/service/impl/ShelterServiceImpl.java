package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.ShelterRequest;
import com.mcsoftware.petcare.model.dto.response.ShelterResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.repository.ShelterRepository;
import com.mcsoftware.petcare.service.interfaces.ShelterService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl extends ShelterService {
    private ShelterRepository shelterRepository;
    private BuilderConverter builderConverter;

    @Override
    public Shelter shelterFinder(String id) {
        try {
            Shelter foundShelter = shelterRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("not found any shelter with id : " + id));
            if(foundShelter != null){
                return foundShelter;
            } else {
                throw new EntityNotFoundException("shelter not found with id : " + id);
            }
        } catch (EntityNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Shelter shelterValidator(Shelter shelter) {
        try{
            if (shelter != null) {
                if (shelter.getName() == null || shelter.getName().trim().isEmpty()) {
                    throw new RuntimeException("Shelter name cannot be null or empty");
                }
                if (shelter.getAddress() == null || shelter.getAddress().trim().isEmpty()) {
                    throw new RuntimeException("Shelter address cannot be null or empty");
                }
                if (shelter.getEmail() == null || shelter.getEmail().trim().isEmpty()) {
                    throw new RuntimeException("Shelter email cannot be null or empty");
                }
                if (shelter.getCity() == null || shelter.getCity().trim().isEmpty()) {
                    throw new RuntimeException("Shelter city cannot be null or empty");
                }
                if (shelter.getPostalCode() == null || shelter.getPostalCode().trim().isEmpty()) {
                    throw new RuntimeException("Shelter postal code cannot be null or empty");
                }
                if (shelter.getCountry() == null || shelter.getCountry().trim().isEmpty()) {
                    throw new RuntimeException("Shelter country cannot be null or empty");
                }
                if (shelter.getPhoneNumber() == null || shelter.getPhoneNumber().trim().isEmpty()) {
                    throw new RuntimeException("Shelter phone number cannot be null or empty");
                }
                if (shelter.getIsActive() == null) {
                    throw new RuntimeException("Shelter status cannot be null");
                }
            } else {
                throw new RuntimeException("Shelter object cannot be null");
            }
            return shelter;
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ShelterResponse create(ShelterRequest shelterRequest) {
        try{
            Shelter newShelter =  builderConverter.shelterBuilder(shelterRequest);
            Shelter validatedShelter = shelterValidator(newShelter);
            return builderConverter.shelterResponseBuilderConvert(validatedShelter);
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found: " + e.getMessage());
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public ShelterResponse update(String id, ShelterRequest shelterRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ShelterResponse getById(String id) {
        return null;
    }

    @Override
    public List<Shelter> getAll() {
        return null;
    }

    @Override
    public List<Pet> getAllPetInShelter() {
        return null;
    }

    @Override
    public List<VaccinatePoint> getVaccinatePointList() {
        return null;
    }
}
