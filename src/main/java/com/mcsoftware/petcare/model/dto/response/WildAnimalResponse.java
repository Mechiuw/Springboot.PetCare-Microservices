package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.constant.EAnimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WildAnimalResponse {
    private String id;
    private String breed;
    private EAnimal animalType;
    private String medicalConditions;
    private String locationFound;
    private Boolean isAlive;
    private String vaccinatePointId;
}
