package com.mcsoftware.petcare.utils.converter;

import com.mcsoftware.petcare.model.dto.request.AdoptionDetailRequest;
import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class TransactionBuilderConverter {
    private final ClientRepository clientRepository;
    private final ShelterRepository shelterRepository;
    private final PetRepository petRepository;
    private final AdoptionDetailRepository adoptionDetailRepository;
    private final AdoptionRepository adoptionRepository;
    public Adoption adoptionRequestToAdoption(AdoptionRequest adoptionRequest){
        try{
            Client client = clientRepository.findById(adoptionRequest.getClientId())
                    .orElseThrow(() -> new EntityNotFoundException("not found any client"));
            Shelter shelter = shelterRepository.findById(adoptionRequest.getShelterId())
                    .orElseThrow(() -> new EntityNotFoundException("not found any shelter"));
            return Adoption.builder()
                    .clientId(client)
                    .shelterId(shelter)
                    .adoptionDetailList(adoptionRequest.getAdoptionDetailList())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public AdoptionResponse adoptionToAdoptionResponse(Adoption adoption){
        try{
            return AdoptionResponse.builder()
                    .id(adoption.getId())
                    .clientId(adoption.getClientId().getId())
                    .shelterId(adoption.getShelterId().getId())
                    .adoptionDetailList(adoption.getAdoptionDetailList())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public AdoptionDetail adoptionDetailRequestToAdoptionDetail(AdoptionDetailRequest adoptionDetailRequest){
        try{
            return AdoptionDetail.builder()
                    .petId(petRepository.findById(adoptionDetailRequest.getPetId())
                            .orElseThrow(() -> new EntityNotFoundException("not found any pet with id : "
                                    + adoptionDetailRequest.getPetId())))
                    .message(adoptionDetailRequest.getMessage())
                    .adoptionId(adoptionRepository.findById(adoptionDetailRequest.getAdoptionId())
                            .orElseThrow(() -> new NoSuchElementException("not found any adoption with id : "
                                    + adoptionDetailRequest.getAdoptionId())))
                    .build();
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

}
