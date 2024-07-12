package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.WildAnimalRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.WildAnimalResponse;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import com.mcsoftware.petcare.repository.WildAnimalRepository;
import com.mcsoftware.petcare.service.interfaces.WildAnimalService;
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
    public WildAnimal wildAnimalValidator() {
        return null;
    }

    @Override
    public RegulationsResponse regulations(String id) {
        return null;
    }
}
