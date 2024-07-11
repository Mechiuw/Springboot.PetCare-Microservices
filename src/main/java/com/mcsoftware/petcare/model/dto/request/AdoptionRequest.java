package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionRequest {
    private String clientId;
    private String shelterId;
    private List<AdoptionDetail> adoptionDetailList;
}
