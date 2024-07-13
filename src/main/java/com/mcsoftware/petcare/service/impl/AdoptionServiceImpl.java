package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.*;
import com.mcsoftware.petcare.repository.AdoptionRepository;
import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import com.mcsoftware.petcare.utils.converter.TransactionBuilderConverter;
import com.mcsoftware.petcare.utils.finder.TransactionFinder;
import com.mcsoftware.petcare.utils.validator.TransactionValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final TransactionBuilderConverter converter;
    private final TransactionValidator validator;
    private final TransactionFinder finder;
    @Override
    public AdoptionResponse create(AdoptionRequest adoptionRequest) throws IllegalAccessException {
        try {
            Adoption newAdoption = converter.adoptionRequestToAdoption(adoptionRequest);
            Adoption validatedAdoption = validator.adoptionValidator(newAdoption);
            Adoption savedAdoption = adoptionRepository.save(validatedAdoption);
            return converter.adoptionToAdoptionResponse(savedAdoption);
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
            Adoption findAdoption = finder.adoptionFinder(id);
            findAdoption.setClientId(finder.clientFinder(adoptionRequest.getClientId()));
            findAdoption.setShelterId(finder.shelterFinder(adoptionRequest.getShelterId()));
            findAdoption.setAdoptionDetailList(finder.adoptionDetailFinder(id));
            Adoption validatedAdoption = validator.adoptionValidator(findAdoption);
            Adoption savedAdoption = adoptionRepository.saveAndFlush(validatedAdoption);
            return converter.adoptionToAdoptionResponse(savedAdoption);
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
        try{
            Adoption findAdoption = finder.adoptionFinder(id);
            findAdoption.setClientId(new Client("DEL","DEL","DEL","DEL",
                    "DEL","DEL","DEL", EStatus.INACTIVE, Collections.emptyList()));
            findAdoption.setShelterId(new Shelter("DEL","DEL","DEL","DEL","DEL",
                    "DEL","DEL","DEL",EStatus.INACTIVE,Collections.emptyList(),Collections.emptyList()));
            findAdoption.setAdoptionDetailList(Collections.emptyList());
            Adoption softDeletedAdoption = adoptionRepository.saveAndFlush(findAdoption);
            return converter.adoptionToAdoptionResponse(softDeletedAdoption);
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public AdoptionResponse getById(String id) {
        try{
            return converter.adoptionToAdoptionResponse(finder.adoptionFinder(id));
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }

    @Override
    public List<Adoption> getAll() {
        try{
            if(adoptionRepository.findAll().isEmpty()){
                return Collections.emptyList();
            }
            return adoptionRepository.findAll();
        } catch (ValidationException e){
            throw new RuntimeException("Validation error: " + e.getMessage());
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found error: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute: " + e.getMessage());
        }
    }
}
