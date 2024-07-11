package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface PetService {

    //CRUD
    PetResponse create(PetRequest petRequest);
    PetResponse update(String id,PetRequest petRequest);
    void delete(String id);
    PetResponse getById(String id);
    List<Pet> getAll();

    PetResponse petBoarding(WildAnimal wildAnimal);

    //FINDERS
    Shelter shelterFinder(String id);
    ServiceProvider serviceProviderFinder(String id);
    Pet petFinder(String id);

    //VALIDATORS
    PetRequest petValidator(PetRequest petRequest);

}
