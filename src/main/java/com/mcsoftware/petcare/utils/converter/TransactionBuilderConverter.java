package com.mcsoftware.petcare.utils.converter;

import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.repository.ClientRepository;
import com.mcsoftware.petcare.repository.ShelterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class TransactionBuilderConverter {
    private final ClientRepository clientRepository;
    private final ShelterRepository shelterRepository;
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


}
