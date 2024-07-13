package com.mcsoftware.petcare.service.impl;
import com.mcsoftware.petcare.utils.converter.BuilderConverter;
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
            //[BUILD] build vaccinate point entity
            VaccinatePoint vaccinatePoint = builderConverter.vaccinatePointBuilderConvert(vaccinatePointRequest);

            //[FILTER] filter vp entity using validator helper class
            VaccinatePoint validatedVaccinatePoint = vpValidator(vaccinatePoint);

            //[SAVE] send validated vp entity to repo and save it
            VaccinatePoint savedVp = vaccinationPointRepository.saveAndFlush(validatedVaccinatePoint);

            //[BUILD] || [RETURN] build the response from the saved vp entity and returns it
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
            //[FIND] Find the existing vp entity from database
            VaccinatePoint findVp = vpFinder(id);

            //[UPDATE] Update each property vp entity has
            findVp.setFirstVaccineDate(vaccinatePointRequest.getFirstVaccinateDate());
            findVp.setSecondVaccineDate(vaccinatePointRequest.getSecondVaccinateDate());
            findVp.setServiceProviderId(serviceProviderRepository.findById(vaccinatePointRequest.getServiceProviderId())
                    .orElseThrow(() -> new NoSuchElementException("not found any service provider")));
            findVp.setShelterId(shelterRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any shelter id")));
            findVp.setWildAnimalId(wildAnimalRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any wild animal id")));

            //[SAVE] save the changes on recent updated entity to send it to database
            VaccinatePoint savedVp = vaccinationPointRepository.saveAndFlush(findVp);

            //[BUILD] || [RETURN]  build the response from the saved vp entity and returns it
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
            //[RETURN] Directly execute delete repo service by getting the entity from id and deletes it
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
            //[RETURN] find and return the entity using finder function (finder -> entity),returns the response convert (entity -> response)
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
            //[FETCH] Fetch All vp data from repo
            List<VaccinatePoint> vps = vaccinationPointRepository.findAll();
            //[CONDITIONS] if it's not empty, return the fetched data
            if (!vps.isEmpty()){
                return vps.stream().toList();
            }
            //[CONDITIONS] if it's empty, return an empty list
            else {
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
            //[RETURN] it returns an entity by checking the repo by id
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
            //[CONDITIONS] checks every each vp entity body request or presented vp entity and assert to be not null
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
                        .wildAnimalId(vaccinatePoint.get().getWildAnimalId().getId())
                        .locationFound(vaccinatePoint.get().getWildAnimalId().getLocationFound())
                        .medicalConditions(vaccinatePoint.get().getWildAnimalId().getMedicalConditions())
                        .vaccinatePointId(vaccinatePoint.get().getId())
                        .regulations(
                                vaccinatePoint.get().animalControl(
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
