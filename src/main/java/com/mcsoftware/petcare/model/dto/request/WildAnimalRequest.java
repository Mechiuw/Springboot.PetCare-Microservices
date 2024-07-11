package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.constant.EAnimal;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WildAnimalRequest {
    private String breed;
    private EAnimal animalType;
    private String medicalConditions;
    private String locationFound;
    private Boolean isAlive;
    private String vaccinatePointId;
}
