package com.mcsoftware.petcare.service.impl;
import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.VaccinatePointRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.VaccinatePointResponse;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.repository.ServiceProviderRepository;
import com.mcsoftware.petcare.repository.ShelterRepository;
import com.mcsoftware.petcare.repository.VaccinationPointRepository;
import com.mcsoftware.petcare.repository.WildAnimalRepository;
import com.mcsoftware.petcare.service.interfaces.VaccinationPointService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class VaccinationPointServiceImpl implements VaccinationPointService {
    private final VaccinationPointRepository vaccinationPointRepository;
    private final BuilderConverter builderConverter;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ShelterRepository shelterRepository;
    private final WildAnimalRepository wildAnimalRepository;
    @Override
    public VaccinatePointResponse create(VaccinatePointRequest vaccinatePointRequest) {
        try {
            VaccinatePoint vaccinatePoint = builderConverter.vaccinatePointBuilderConvert(vaccinatePointRequest);
            VaccinatePoint validatedVaccinatePoint = vpValidator(vaccinatePoint);
            VaccinatePoint savedVp = vaccinationPointRepository.save(validatedVaccinatePoint);
            return builderConverter.vaccinatePointResponseBuilderConvert(savedVp);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public VaccinatePointResponse update(String id, VaccinatePointRequest vaccinatePointRequest) {
        try {
            VaccinatePoint findVp = vpFinder(id);

            findVp.setFirstVaccineDate(vaccinatePointRequest.getFirstVaccinateDate());
            findVp.setSecondVaccineDate(vaccinatePointRequest.getSecondVaccinateDate());
            findVp.setServiceProviderId(serviceProviderRepository.findById(vaccinatePointRequest.getServiceProviderId())
                    .orElseThrow(() -> new NoSuchElementException("not found any service provider")));
            findVp.setShelterId(shelterRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any shelter id")));
            findVp.setWildAnimalId(wildAnimalRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any wild animal id")));
            VaccinatePoint savedVp = vaccinationPointRepository.saveAndFlush(findVp);
            return builderConverter.vaccinatePointResponseBuilderConvert(savedVp);
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
        try {
            vaccinationPointRepository.delete(
                    vaccinationPointRepository.findById(id)
                            .orElseThrow(() -> new NoSuchElementException("not found any vaccination point")));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public VaccinatePointResponse getById(String id) {
        try {
            return builderConverter.vaccinatePointResponseBuilderConvert(vpFinder(id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<VaccinatePoint> getAll() {
        try {
            List<VaccinatePoint> vps = vaccinationPointRepository.findAll();
            if (!vps.isEmpty()){
                return vps.stream().toList();
            } else {
                return Collections.emptyList();
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
    public VaccinatePoint vpFinder(String id) {
        try {
            return vaccinationPointRepository
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any vp entity with id : " + id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        }  catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public VaccinatePoint vpValidator(VaccinatePoint vaccinatePoint) {
        try {
            if (vaccinatePoint != null) {
                if (vaccinatePoint.getFirstVaccineDate() == null) {
                    throw new ValidationException("First vaccine date can't be null");
                }
                if (vaccinatePoint.getSecondVaccineDate() == null) {
                    throw new ValidationException("Second vaccine date can't be null");
                }
                if (vaccinatePoint.getWildAnimalId() == null) {
                    throw new ValidationException("Wild animal ID can't be null");
                }
                if (vaccinatePoint.getShelterId() == null) {
                    throw new ValidationException("Shelter ID can't be null");
                }
                if (vaccinatePoint.getServiceProviderId() == null) {
                    throw new ValidationException("Service provider ID can't be null");
                }
            } else {
                throw new ValidationException("Validation exception || VaccinatePoint object is null");
            }
            return vaccinatePoint;
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public RegulationsResponse regulations(String id) {
        try {
            Optional<VaccinatePoint> vaccinatePoint = vaccinationPointRepository.findById(id);
            if(vaccinatePoint.isPresent()) {
                return RegulationsResponse.builder()
                        .regulations(vaccinatePoint.get().animalControl(
                                vaccinatePoint.get().getWildAnimalId().getBreed(),
                                vaccinatePoint.get().getServiceProviderId().getFirstName(),
                                "CONFIRMED"))
                        .build();
            } else {
                throw new NoSuchElementException("vaccinate point is not present");
            }
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
}
