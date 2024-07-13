package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.repository.AdoptionRepository;
import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import com.mcsoftware.petcare.utils.converter.TransactionBuilderConverter;
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
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final TransactionBuilderConverter transactionConverter;
    private final TransactionValidator validator;
    @Override
    public AdoptionResponse create(AdoptionRequest adoptionRequest) throws IllegalAccessException {
        try {
            Adoption newAdoption = transactionConverter.adoptionRequestToAdoption(adoptionRequest);
            Adoption validatedAdoption = validator.adoptionValidator(newAdoption);
            Adoption savedAdoption = adoptionRepository.save(validatedAdoption);
            return transactionConverter.adoptionToAdoptionResponse(savedAdoption);
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public AdoptionResponse update(String id, AdoptionRequest adoptionRequest) {
        try {
            return null
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
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
