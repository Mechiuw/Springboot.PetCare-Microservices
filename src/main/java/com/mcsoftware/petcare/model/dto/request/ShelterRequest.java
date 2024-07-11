package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.constant.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ShelterRequest {
    private String name;
    private String address;
    private String email;
    private String city;
    private String postalCode;
    private EStatus isActive;
}
