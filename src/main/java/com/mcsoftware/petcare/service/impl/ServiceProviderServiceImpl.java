package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.ServiceProviderRequest;
import com.mcsoftware.petcare.model.dto.response.ServiceProviderResponse;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.repository.ServiceProviderRepository;
import com.mcsoftware.petcare.service.interfaces.ServiceProviderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;
    private final BuilderConverter builderConverter;

    @Override
    public ServiceProviderResponse create(ServiceProviderRequest serviceProviderRequest) {
        try {
            ServiceProvider newServiceProvider = builderConverter.serviceProviderBuilderConvert(serviceProviderRequest);
            ServiceProvider validatedSp = spValidator(newServiceProvider);
            ServiceProvider savedSp = serviceProviderRepository.save(validatedSp);
            return builderConverter.serviceProviderResponseBuilderConvert(savedSp);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public ServiceProviderResponse update(String id, ServiceProviderRequest serviceProviderRequest) {
        try {
            ServiceProvider foundSp = spFinder(id);
            assert serviceProviderRequest != null : "service provider request can't be null";
            if (foundSp != null) {
                foundSp.setProfileIdNumber(serviceProviderRequest.getProfileIdNumber());
                foundSp.setFirstName(serviceProviderRequest.getFirstName());
                foundSp.setLastName(serviceProviderRequest.getLastName());
                foundSp.setEmail(serviceProviderRequest.getEmail());
                foundSp.setAddress(serviceProviderRequest.getAddress());
                foundSp.setType(serviceProviderRequest.getType());
                foundSp.setSalary(serviceProviderRequest.getSalary());
                foundSp.setIsVaccinate(serviceProviderRequest.getIsVaccinate());
                foundSp.setJoinedDate(serviceProviderRequest.getJoinedDate());
                foundSp.setStatus(serviceProviderRequest.getStatus());
                ServiceProvider savedSp = serviceProviderRepository.save(foundSp);
                return builderConverter.serviceProviderResponseBuilderConvert(savedSp);
            } else {
                throw new RuntimeException("failed to Execute");
            }
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public void delete(String id) {
        try{
            serviceProviderRepository.delete(serviceProviderRepository
                    .findById(id)
                    .orElseThrow(
                            () -> new NoSuchElementException("not found any service provider with id : " + id)));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public ServiceProviderResponse getById(String id) {
        return null;
    }

    @Override
    public List<ServiceProvider> getAll() {
        return null;
    }

    @Override
    public List<ServiceProvider> getAllAssignedAnimals(String id) {
        return null;
    }

    @Override
    public List<ServiceProvider> getAllVaccinatePoints(String id) {
        return null;
    }

    @Override
    public ServiceProviderResponse eVaxDose(String id) {
        return null;
    }

    @Override
    public ServiceProvider spFinder(String id) {
        try {
            return serviceProviderRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("not found any service provider with id : " + id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public ServiceProvider spValidator(ServiceProvider serviceProvider) {
        if(serviceProvider != null){
            if (serviceProvider.getFirstName() == null || serviceProvider.getFirstName().trim().isEmpty()) {
                throw new RuntimeException("Validation error || Service provider first name is empty");
            }
            if (serviceProvider.getLastName() == null || serviceProvider.getLastName().trim().isEmpty()) {
                throw new RuntimeException("Validation error || Service provider last name is empty");
            }
            if (serviceProvider.getEmail() == null || serviceProvider.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Validation error || Service provider email is empty");
            }
            if (serviceProvider.getAddress() == null || serviceProvider.getAddress().trim().isEmpty()) {
                throw new RuntimeException("Validation error || Service provider address is empty");
            }
            if (serviceProvider.getType() == null) {
                throw new RuntimeException("Validation error || Service provider type is not set");
            }
            if (serviceProvider.getSalary() == null) {
                throw new RuntimeException("Validation error || Service provider salary is not set");
            }
            if (serviceProvider.getIsVaccinate() == null) {
                throw new RuntimeException("Validation error || Service provider vaccination status is not set");
            }
            if (serviceProvider.getJoinedDate() == null) {
                throw new RuntimeException("Validation error || Service provider joined date is not set");
            }
            if (serviceProvider.getStatus() == null) {
                throw new RuntimeException("Validation error || Service provider status is not set");
            }
        } else {
            throw new RuntimeException("validation error");
        }
        return serviceProvider;
    }
}
