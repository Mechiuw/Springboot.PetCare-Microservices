package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.AdoptionDetailRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionDetailResponse;
import com.mcsoftware.petcare.model.entity.AdoptionDetail;

import java.util.List;

public interface AdoptionDetailService {
    AdoptionDetailResponse create(AdoptionDetailRequest adoptionDetailRequest) throws IllegalAccessException;
    AdoptionDetailResponse update(String id,AdoptionDetailRequest adoptionDetailRequest);
    void delete(String id);
    AdoptionDetailResponse getById(String id);
    List<AdoptionDetail> getAll();
}
