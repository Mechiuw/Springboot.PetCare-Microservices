package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;

import java.util.List;

public interface AdoptionService {
    AdoptionResponse create(AdoptionRequest adoptionRequest);
    AdoptionResponse update(String id,AdoptionRequest adoptionRequest);
    AdoptionResponse softDelete(String id);
    AdoptionResponse getById(String id);
    List<Adoption> getAll();
}
