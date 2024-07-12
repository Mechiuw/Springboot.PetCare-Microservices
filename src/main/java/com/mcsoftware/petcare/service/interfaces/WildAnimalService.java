package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.WildAnimalRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.WildAnimalResponse;
import com.mcsoftware.petcare.model.entity.WildAnimal;

import java.util.List;

public interface WildAnimalService {
    WildAnimalResponse create(WildAnimalRequest wildAnimalRequest);
    WildAnimalResponse update(String id,WildAnimalRequest wildAnimalRequest);
    void delete(String id);
    WildAnimalResponse getById(String id);
    List<WildAnimal> getAll();
    WildAnimalResponse getWildAnimalVax(WildAnimalRequest wildAnimalRequest);
    WildAnimal wildAnimalFinder();
    WildAnimal wildAnimalValidator();
    RegulationsResponse regulations(String id);
}
