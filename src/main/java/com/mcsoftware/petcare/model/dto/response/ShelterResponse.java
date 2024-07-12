package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ShelterResponse {
    private String id;
    private String name;
    private String address;
    private String email;
    private String city;
    private String postalCode;
    private EStatus isActive;
    private List<Pet> petInShelter;
    private List<VaccinatePoint> vaccinatePoints;
}
