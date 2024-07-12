package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.ShelterRequest;
import com.mcsoftware.petcare.model.dto.response.ShelterResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;

import java.util.List;

public interface ShelterService {
    //CRUD
    ShelterResponse create(ShelterRequest shelterRequest);
    ShelterResponse update(String id, ShelterRequest shelterRequest);
    void delete(String id);
    ShelterResponse getById(String id);
    List<Shelter> getAll();

    //BUSINESS SERVICE
    List<Pet> getAllPetInShelter(String id);
    List<VaccinatePoint> getVaccinatePointList(String id);

    //HELPER / FINDER
    Shelter shelterFinder(String id);

    //VALIDATOR
    Shelter shelterValidator(Shelter shelter);
}
