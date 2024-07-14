package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.AdoptionDetailRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionDetailResponse;
import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import com.mcsoftware.petcare.repository.AdoptionDetailRepository;
import com.mcsoftware.petcare.service.interfaces.AdoptionDetailService;
import com.mcsoftware.petcare.utils.converter.TransactionBuilderConverter;
import com.mcsoftware.petcare.utils.finder.TransactionFinder;
import com.mcsoftware.petcare.utils.validator.TransactionValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class AdoptionDetailServiceImpl implements AdoptionDetailService {
    private final AdoptionDetailRepository adoptionDetailRepository;
    private final TransactionBuilderConverter converter;
    private final TransactionFinder finder;
    private final TransactionValidator validator;

    @Override
    public AdoptionDetailResponse create(AdoptionDetailRequest adoptionDetailRequest) throws IllegalAccessException {
        AdoptionDetail detail = converter.adoptionDetailRequestToAdoptionDetail(adoptionDetailRequest);
        AdoptionDetail validatedAD = validator.validator(detail);
        return null;
    }

    @Override
    public AdoptionDetailResponse update(String id, AdoptionDetailRequest adoptionDetailRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public AdoptionDetailResponse getById(String id) {
        return null;
    }

    @Override
    public List<AdoptionDetail> getAll() {
        return null;
    }
}
