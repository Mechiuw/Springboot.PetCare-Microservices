package com.mcsoftware.petcare.model.converter;

import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.Shelter;

public class BuilderConverter {

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
}
