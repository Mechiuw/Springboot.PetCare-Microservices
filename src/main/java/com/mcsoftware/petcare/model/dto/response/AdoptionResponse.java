package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.model.entity.AdoptionDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AdoptionResponse {
    private String id;
    private String clientId;
    private String shelterId;
    private List<AdoptionDetail> adoptionDetailList;
}
