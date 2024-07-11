package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.model.entity.WildAnimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class VaccinatePointRequest {
    private Date firstVaccinateDate;
    private Date secondVaccinateDate;
    private String wildAnimalId;
    private String shelterId;
    private String serviceProviderId;
}
