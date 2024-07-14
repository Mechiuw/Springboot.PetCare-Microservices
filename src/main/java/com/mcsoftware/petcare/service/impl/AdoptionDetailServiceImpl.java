package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.AdoptionDetailRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionDetailResponse;
import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import com.mcsoftware.petcare.repository.AdoptionDetailRepository;
import com.mcsoftware.petcare.service.interfaces.AdoptionDetailService;
import com.mcsoftware.petcare.utils.converter.TransactionBuilderConverter;
import com.mcsoftware.petcare.utils.finder.TransactionFinder;
import com.mcsoftware.petcare.utils.validator.TransactionValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
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
        try{
        AdoptionDetail detail = converter.adoptionDetailRequestToAdoptionDetail(adoptionDetailRequest);
        AdoptionDetail validatedAd = validator.validator(detail);
        AdoptionDetail savedAd = adoptionDetailRepository.save(validatedAd);
        return converter.adoptionDetailToAdoptionDetailResponse(savedAd);
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public AdoptionDetailResponse update(String id, AdoptionDetailRequest adoptionDetailRequest) {
        try {
            return null;
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try{

        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public AdoptionDetailResponse getById(String id) {
        try{
        return null;
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public List<AdoptionDetail> getAll() {
        try{
        return null;
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }
}
