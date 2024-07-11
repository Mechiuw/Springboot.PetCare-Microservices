package com.mcsoftware.petcare.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AdoptionDetailResponse {
    private String id;
    private String petId;
    private String message;
    private String adoptionId;
}
