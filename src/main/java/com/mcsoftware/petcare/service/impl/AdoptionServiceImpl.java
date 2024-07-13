package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.repository.AdoptionRepository;
import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import com.mcsoftware.petcare.utils.converter.TransactionBuilderConverter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final TransactionBuilderConverter transactionBuilderConverter;

    @Override
    public AdoptionResponse create(AdoptionRequest adoptionRequest) {

        return null;
    }

    @Override
    public AdoptionResponse update(String id, AdoptionRequest adoptionRequest) {
        return null;
    }

    @Override
    public AdoptionResponse softDelete(String id) {
        return null;
    }

    @Override
    public AdoptionResponse getById(String id) {
        return null;
    }

    @Override
    public List<Adoption> getAll() {
        return null;
    }
}
