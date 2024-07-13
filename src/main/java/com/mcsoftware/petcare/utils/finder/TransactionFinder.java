package com.mcsoftware.petcare.utils.finder;

import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.repository.AdoptionRepository;
import com.mcsoftware.petcare.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionFinder {
    private final AdoptionRepository adoptionRepository;
    private final ClientRepository clientRepository;

    public Adoption adoptionFinder(String id){
        try{
            return adoptionRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any adoption with id: " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public Client clientFinder(String id){
        try{
            return clientRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any client with id: " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}