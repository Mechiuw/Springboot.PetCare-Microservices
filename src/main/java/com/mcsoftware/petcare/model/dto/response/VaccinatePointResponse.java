package com.mcsoftware.petcare.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class VaccinatePointResponse {
    private Date firstVaccinateDate;
    private Date secondVaccinateDate;
    private String wildAnimalId;
    private String shelterId;
    private String serviceProviderId;
}
