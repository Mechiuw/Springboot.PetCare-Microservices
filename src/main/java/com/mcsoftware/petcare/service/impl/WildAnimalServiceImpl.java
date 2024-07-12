package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.WildAnimalRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.WildAnimalResponse;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import com.mcsoftware.petcare.repository.WildAnimalRepository;
import com.mcsoftware.petcare.service.interfaces.WildAnimalService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WildAnimalServiceImpl implements WildAnimalService {
    private final WildAnimalRepository wildAnimalRepository;
    private final BuilderConverter builderConverter;

    @Override
    public WildAnimalResponse create(WildAnimalRequest wildAnimalRequest) {
        WildAnimal newAnimal = builderConverter.wildAnimalBuilderConvert(wildAnimalRequest);

        return null;
    }

    @Override
    public WildAnimalResponse update(String id, WildAnimalRequest wildAnimalRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public WildAnimalResponse getById(String id) {
        return null;
    }

    @Override
    public List<WildAnimal> getAll() {
        return null;
    }

    @Override
    public WildAnimalResponse getWildAnimalVax(WildAnimalRequest wildAnimalRequest) {
        return null;
    }

    @Override
    public WildAnimal wildAnimalFinder() {
        return null;
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
