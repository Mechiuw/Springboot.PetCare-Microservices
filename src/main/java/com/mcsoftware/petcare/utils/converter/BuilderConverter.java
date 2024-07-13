package com.mcsoftware.petcare.utils.converter;

import com.mcsoftware.petcare.model.dto.request.*;
import com.mcsoftware.petcare.model.dto.response.*;
import com.mcsoftware.petcare.model.entity.*;
import com.mcsoftware.petcare.repository.ServiceProviderRepository;
import com.mcsoftware.petcare.repository.ShelterRepository;
import com.mcsoftware.petcare.repository.WildAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class BuilderConverter {
    private final ServiceProviderRepository serviceProviderRepository;
    private final WildAnimalRepository wildAnimalRepository;
    private final ShelterRepository shelterRepository;

    public Pet petBuilderConvert(PetRequest validatedRequest, Shelter shelter, ServiceProvider serviceProvider){
        try {
            return Pet.builder()
                    .name(validatedRequest.getName())
                    .animalType(validatedRequest.getAnimalType())
                    .breed(validatedRequest.getBreed())
                    .age(validatedRequest.getAge())
                    .medicalConditions(validatedRequest.getMedicalConditions())
                    .shelterAdoptId(shelter)
                    .serviceProviderId(serviceProvider)
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
    public PetResponse petResponseBuilderConvert(Pet newPet,PetRequest validatedRequest){
        try{
            return PetResponse.builder()
                    .id(newPet.getId())
                    .name(newPet.getName())
                    .animalType(newPet.getAnimalType())
                    .breed(newPet.getBreed())
                    .age(newPet.getAge())
                    .medicalConditions(newPet.getMedicalConditions())
                    .shelterAdoptId(validatedRequest.getShelterAdoptId())
                    .serviceProviderId(validatedRequest.getServiceProviderId())
                    .clientAdoptId(validatedRequest.getClientAdoptId())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public PetResponse petResponseBuilder(Pet pet){
        try{
            return PetResponse.builder()
                    .id(pet.getId())
                    .name(pet.getName())
                    .animalType(pet.getAnimalType())
                    .breed(pet.getBreed())
                    .medicalConditions(pet.getMedicalConditions())
                    .shelterAdoptId(pet.getShelterAdoptId().getId())
                    .serviceProviderId(pet.getServiceProviderId().getId())
                    .clientAdoptId(pet.getClientAdoptId().getId())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public PetRequest animalToPetConverter(WildAnimal wildAnimal,String name,String age,String shelterAdoptId,String serviceProviderId){
        try{
            return PetRequest.builder()
                    .name(name)
                    .animalType(wildAnimal.getAnimalType())
                    .breed(wildAnimal.getBreed())
                    .age(age)
                    .medicalConditions(wildAnimal.getMedicalConditions())
                    .shelterAdoptId(shelterAdoptId)
                    .serviceProviderId(serviceProviderId)
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public Client clientBuilderConvert(ClientRequest clientRequest){
        try{
            return Client.builder()
                    .firstName(clientRequest.getFirstName())
                    .lastName(clientRequest.getLastName())
                    .profileIdNumber(clientRequest.getProfileIdNumber())
                    .email(clientRequest.getEmail())
                    .address(clientRequest.getAddress())
                    .phoneNumber(clientRequest.getPhoneNumber())
                    .status(clientRequest.getStatus())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public ClientResponse clientResponseBuilder(Client client){
        try{
            return ClientResponse.builder()
                    .id(client.getId())
                    .firstName(client.getFirstName())
                    .lastName(client.getLastName())
                    .profileIdNumber(client.getProfileIdNumber())
                    .email(client.getEmail())
                    .address(client.getAddress())
                    .phoneNumber(client.getPhoneNumber())
                    .status(client.getStatus())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public Shelter shelterBuilder(ShelterRequest shelterRequest){
        try{
            return Shelter.builder()
                    .name(shelterRequest.getName())
                    .address(shelterRequest.getAddress())
                    .email(shelterRequest.getEmail())
                    .city(shelterRequest.getCity())
                    .postalCode(shelterRequest.getPostalCode())
                    .isActive(shelterRequest.getIsActive())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public ShelterResponse shelterResponseBuilderConvert(Shelter shelter){
        try{
            return ShelterResponse.builder()
                    .id(shelter.getId())
                    .name(shelter.getName())
                    .address(shelter.getAddress())
                    .email(shelter.getEmail())
                    .city(shelter.getCity())
                    .postalCode(shelter.getPostalCode())
                    .isActive(shelter.getIsActive())
                    .build();
        }catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public ServiceProvider serviceProviderBuilderConvert(ServiceProviderRequest serviceProviderRequest){
        try{
            return ServiceProvider.builder()
                    .profileIdNumber(serviceProviderRequest.getProfileIdNumber())
                    .firstName(serviceProviderRequest.getFirstName())
                    .lastName(serviceProviderRequest.getLastName())
                    .email(serviceProviderRequest.getEmail())
                    .address(serviceProviderRequest.getAddress())
                    .type(serviceProviderRequest.getType())
                    .salary(serviceProviderRequest.getSalary())
                    .isVaccinate(serviceProviderRequest.getIsVaccinate())
                    .joinedDate(serviceProviderRequest.getJoinedDate())
                    .status(serviceProviderRequest.getStatus())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public ServiceProviderResponse serviceProviderResponseBuilderConvert(ServiceProvider serviceProvider){
        try{
            return ServiceProviderResponse.builder()
                    .profileIdNumber(serviceProvider.getProfileIdNumber())
                    .firstName(serviceProvider.getFirstName())
                    .lastName(serviceProvider.getLastName())
                    .email(serviceProvider.getEmail())
                    .address(serviceProvider.getAddress())
                    .type(serviceProvider.getType())
                    .salary(serviceProvider.getSalary())
                    .isVaccinate(serviceProvider.getIsVaccinate())
                    .joinedDate(serviceProvider.getJoinedDate())
                    .status(serviceProvider.getStatus())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public ServiceProviderResponse serviceProviderResponseEVax(ServiceProvider serviceProvider){
        try{
            return ServiceProviderResponse.builder()
                    .profileIdNumber(serviceProvider.getProfileIdNumber())
                    .firstName(serviceProvider.getFirstName())
                    .lastName(serviceProvider.getLastName())
                    .isVaccinate(serviceProvider.getIsVaccinate())
                    .joinedDate(serviceProvider.getJoinedDate())
                    .status(serviceProvider.getStatus())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public BehaviorResponse petBehaviorResponseBuilder(Pet pet){
        try{
            return BehaviorResponse.builder()
                    .petId(pet.getId())
                    .petBehavior(pet.getBehavior())
                    .message(pet.getMedicalConditions())
                    .build();
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public WildAnimal wildAnimalBuilderConvert(WildAnimalRequest wildAnimalRequest){
        try {
            return WildAnimal.builder()
                    .breed(wildAnimalRequest.getBreed())
                    .animalType(wildAnimalRequest.getAnimalType())
                    .medicalConditions(wildAnimalRequest.getMedicalConditions())
                    .locationFound(wildAnimalRequest.getLocationFound())
                    .isAlive(wildAnimalRequest.getIsAlive())
                    .build();
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
    public WildAnimalResponse wildAnimalResponseBuilderConvert(WildAnimal wildAnimal){
        try{
            return WildAnimalResponse.builder()
                    .id(wildAnimal.getId())
                    .breed(wildAnimal.getBreed())
                    .animalType(wildAnimal.getAnimalType())
                    .medicalConditions(wildAnimal.getMedicalConditions())
                    .locationFound(wildAnimal.getLocationFound())
                    .isAlive(wildAnimal.getIsAlive())
                    .vaccinatePointId(wildAnimal.getVaccinatePointId().getId())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public VaccinatePoint vaccinatePointBuilderConvert(VaccinatePointRequest vaccinatePointRequest){
        try{
            return VaccinatePoint.builder()
                    .firstVaccineDate(vaccinatePointRequest.getFirstVaccinateDate())
                    .secondVaccineDate(vaccinatePointRequest.getSecondVaccinateDate())
                    .wildAnimalId(wildAnimalRepository.findById(vaccinatePointRequest.getWildAnimalId())
                            .orElseThrow(() -> new NoSuchElementException("not found any wild animal")))
                    .serviceProviderId(serviceProviderRepository.findById(vaccinatePointRequest.getServiceProviderId())
                            .orElseThrow(() -> new NoSuchElementException("not found any service provider")))
                    .shelterId(shelterRepository.findById(vaccinatePointRequest.getShelterId())
                            .orElseThrow(() -> new NoSuchElementException("not found any shelter")))
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }

    public VaccinatePointResponse vaccinatePointResponseBuilderConvert(VaccinatePoint vaccinatePoint){
        try{
            return VaccinatePointResponse.builder()
                    .id(vaccinatePoint.getId())
                    .firstVaccinateDate(vaccinatePoint.getFirstVaccineDate())
                    .secondVaccinateDate(vaccinatePoint.getSecondVaccineDate())
                    .wildAnimalId(vaccinatePoint.getWildAnimalId().getId())
                    .serviceProviderId(vaccinatePoint.getServiceProviderId().getId())
                    .shelterId(vaccinatePoint.getShelterId().getId())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}