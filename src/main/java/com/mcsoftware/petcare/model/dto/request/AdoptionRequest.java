package com.mcsoftware.petcare.model.dto.request;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionRequest {
    private String id;
    private String clientId;
    private String shelterId;
}
