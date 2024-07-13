package com.mcsoftware.petcare.utils.finder;

import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.repository.AdoptionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionFinder {
    private final AdoptionRepository adoptionRepository;

    public Adoption adoptionFinder(String id){
        try{
            return adoptionRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any adoption with id: " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}
