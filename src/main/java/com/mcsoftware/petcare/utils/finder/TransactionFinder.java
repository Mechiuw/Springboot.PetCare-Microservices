package com.mcsoftware.petcare.utils.finder;

import com.mcsoftware.petcare.model.entity.*;
import com.mcsoftware.petcare.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionFinder {
    private final AdoptionRepository adoptionRepository;
    private final ClientRepository clientRepository;
    private final ShelterRepository shelterRepository;
    private final AdoptionDetailRepository adoptionDetailRepository;
    private  final PetRepository petRepository;

    public Pet petFinder(String id){
        try{
            return petRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any pet with id : " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
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

    public Shelter shelterFinder(String id){
        try{
            return shelterRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any shelter with id: " + id));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public List<AdoptionDetail> adoptionDetailListFinder(String id){
        try{
            Optional<Adoption> adoption = adoptionRepository.findById(id);
            if(adoption.isPresent() && !adoption.get().getAdoptionDetailList().isEmpty()){
                return adoption.get().getAdoptionDetailList();
            } else if (adoption.isPresent()){
                return Collections.emptyList();
            } else {
                throw new EntityNotFoundException("adoption not found with id : " + id);
            }
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public AdoptionDetail adoptionDetailFinder(String id){
        try{
            Optional<AdoptionDetail> foundAd = adoptionDetailRepository.findById(id);
            if(foundAd.isPresent()){
                return foundAd.get();
            } else {
                throw new EntityNotFoundException("adoption detail not found with id : " + id);
            }
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}
