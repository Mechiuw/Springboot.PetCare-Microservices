package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.ServiceProviderRequest;
import com.mcsoftware.petcare.model.dto.response.ServiceProviderResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;

import java.util.List;

public interface ServiceProviderService {

    //CRUD
    ServiceProviderResponse create(ServiceProviderRequest serviceProviderRequest);
    ServiceProviderResponse update(String id,ServiceProviderRequest serviceProviderRequest);
    void delete(String id);
    ServiceProviderResponse getById(String id);
    List<ServiceProvider> getAll();

    //BUSINESS SERVICE
    List<Pet> getAllAssignedAnimals(String id);
    List<VaccinatePoint> getAllVaccinatePoints(String id);
    ServiceProviderResponse eVaxDose(String id);

    //FINDER
    ServiceProvider spFinder(String id);

    // VALIDATOR
    ServiceProvider spValidator(ServiceProvider serviceProvider);

}
