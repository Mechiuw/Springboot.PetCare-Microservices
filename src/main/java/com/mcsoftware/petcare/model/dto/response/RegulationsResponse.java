package com.mcsoftware.petcare.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RegulationsResponse {
    private String wildAnimalId;
    private String locationFound;
    private String medicalConditions;
    private String vaccinatePointId;
    private String regulations;
}
