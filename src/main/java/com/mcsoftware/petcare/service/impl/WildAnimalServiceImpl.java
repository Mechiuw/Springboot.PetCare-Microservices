package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.WildAnimalRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.WildAnimalResponse;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import com.mcsoftware.petcare.repository.WildAnimalRepository;
import com.mcsoftware.petcare.service.interfaces.WildAnimalService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WildAnimalServiceImpl implements WildAnimalService {
    private final WildAnimalRepository wildAnimalRepository;
    private final BuilderConverter builderConverter;

    @Override
    public WildAnimalResponse create(WildAnimalRequest wildAnimalRequest) {
        try {
            WildAnimal newAnimal = builderConverter.wildAnimalBuilderConvert(wildAnimalRequest);
            WildAnimal validatedAnimal = wildAnimalValidator(newAnimal);
            WildAnimal savedAnimal = wildAnimalRepository.save(validatedAnimal);
            return builderConverter.wildAnimalResponseBuilderConvert(savedAnimal);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public WildAnimalResponse update(String id, WildAnimalRequest wildAnimalRequest) {
        try {
            WildAnimal foundAnimal = wildAnimalFinder(id);
            foundAnimal.setBreed(wildAnimalRequest.getBreed());
            foundAnimal.setAnimalType(wildAnimalRequest.getAnimalType());
            foundAnimal.setMedicalConditions(wildAnimalRequest.getMedicalConditions());
            foundAnimal.setLocationFound(wildAnimalRequest.getLocationFound());
            foundAnimal.setIsAlive(wildAnimalRequest.getIsAlive());
            WildAnimal savedAnimal = wildAnimalRepository.saveAndFlush(foundAnimal);
            return builderConverter.wildAnimalResponseBuilderConvert(savedAnimal);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            wildAnimalRepository.delete(wildAnimalFinder(id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public WildAnimalResponse getById(String id) {
        try {
            return builderConverter.wildAnimalResponseBuilderConvert(wildAnimalFinder(id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<WildAnimal> getAll() {
        try {
            List<WildAnimal> fetch = wildAnimalRepository.findAll();
            if(!fetch.isEmpty()){
                return fetch;
            } else {
                return Collections.emptyList();
            }
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public WildAnimalResponse getWildAnimalVax(WildAnimalRequest wildAnimalRequest) {
        return null;
    }

    @Override
    public WildAnimal wildAnimalFinder(String id) {
        try {
            return wildAnimalRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("not found any wild animal with id: " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public WildAnimal wildAnimalValidator(WildAnimal wildAnimal) {
        if (wildAnimal != null) {
            if (wildAnimal.getBreed() == null || wildAnimal.getBreed().trim().isEmpty()) {
                throw new ValidationException("Validation error || Breed can't be null or empty");
            }
            if (wildAnimal.getAnimalType() == null) {
                throw new ValidationException("Validation error || Animal type can't be null");
            }
            if (wildAnimal.getMedicalConditions() == null || wildAnimal.getMedicalConditions().trim().isEmpty()) {
                throw new ValidationException("Validation error || Medical conditions can't be null or empty");
            }
            if (wildAnimal.getLocationFound() == null || wildAnimal.getLocationFound().trim().isEmpty()) {
                throw new ValidationException("Validation error || Location found can't be null or empty");
            }
            if (wildAnimal.getIsAlive() == null) {
                throw new ValidationException("Validation error || Is alive status can't be null");
            }
        } else {
            throw new ValidationException("Validation exception caught || Wild animal object is null");
        }
        return wildAnimal;
    }


    @Override
    public RegulationsResponse regulations(String id) {
        return null;
    }
}
