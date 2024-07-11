package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.Shelter;
import lombok.RequiredArgsConstructor;

public interface PetService {
    PetResponse create(PetRequest petRequest);
    PetResponse update(String id,PetRequest petRequest);
    PetResponse delete(String id);
    PetResponse getById(String id);
    PetResponse getAll();
    Shelter shelterFinder(String id);
    ServiceProvider serviceProviderFinder(String id);
    PetRequest petValidator(PetRequest petRequest);

}
