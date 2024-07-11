package com.mcsoftware.petcare.model.converter;

import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.Shelter;

public class BuilderConverter {

    public Pet PetBuilderConvert(PetRequest validatedRequest, Shelter shelter, ServiceProvider serviceProvider){
        return Pet.builder()
                .name(validatedRequest.getName())
                .animalType(validatedRequest.getAnimalType())
                .breed(validatedRequest.getBreed())
                .age(validatedRequest.getAge())
                .medicalConditions(validatedRequest.getMedicalConditions())
                .shelterAdoptId(shelter)
                .serviceProviderId(serviceProvider)
                .build();
    }
}
