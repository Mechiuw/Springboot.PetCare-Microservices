package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.AdoptionDetailRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionDetailResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import com.mcsoftware.petcare.model.entity.Pet;
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

import java.nio.channels.NoConnectionPendingException;
import java.util.List;
import java.util.Optional;

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
            Pet foundPet = finder.petFinder(adoptionDetailRequest.getPetId());
            String foundMessage = adoptionDetailRequest.getMessage();
            Adoption foundAdoption = finder.adoptionFinder(adoptionDetailRequest.getAdoptionId());
            AdoptionDetail foundAd = finder.adoptionDetailFinder(id);
            foundAd.setPetId(foundPet);
            foundAd.setMessage(foundMessage);
            foundAd.setAdoptionId(foundAdoption);
            AdoptionDetail savedAd = adoptionDetailRepository.saveAndFlush(foundAd);
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
    public void delete(String id) {
        try{
            Optional<AdoptionDetail> foundAd = adoptionDetailRepository.findById(id);
            if(foundAd.isPresent()) {
                adoptionDetailRepository.delete(foundAd.get());
            } else {
                throw new EntityNotFoundException("not found any adoption detail with id : " + id);
            }
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
            return finder.adoptionDetailFinder(adoptionDetailRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any adotion detail with id : " + id));
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
