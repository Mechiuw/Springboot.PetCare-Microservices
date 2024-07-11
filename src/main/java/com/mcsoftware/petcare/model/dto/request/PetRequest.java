package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.constant.EAnimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PetRequest {
    private String id;
    private String name;
    private EAnimal animalType;
    private String breed;
    private String age;
    private String medicalConditions;
    private String clientAdoptId;
    private String shelterAdoptId;
    private String serviceProviderId;
}
