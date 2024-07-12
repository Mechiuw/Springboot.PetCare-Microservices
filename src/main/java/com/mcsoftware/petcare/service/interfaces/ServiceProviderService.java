package com.mcsoftware.petcare.service.interfaces;

import com.mcsoftware.petcare.model.dto.request.ServiceProviderRequest;
import com.mcsoftware.petcare.model.dto.response.ServiceProviderResponse;
import com.mcsoftware.petcare.model.entity.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {

    //CRUD
    ServiceProviderResponse create(ServiceProviderRequest serviceProviderRequest);
    ServiceProviderResponse update(String id,ServiceProviderRequest serviceProviderRequest);
    void delete(String id);
    ServiceProviderResponse getById(String id);
    List<ServiceProvider> getAll();

    //BUSINESS SERVICE
    List<ServiceProvider> getAllAssignedAnimals(String id);
    List<ServiceProvider> getAllVaccinatePoints(String id);
    ServiceProviderResponse eVaxDose(String id);

    //FINDER
    ServiceProvider spFinder(String id);

    // VALIDATOR
    ServiceProvider spValidator(ServiceProvider serviceProvider);

}
