package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.constant.EType;
import com.mcsoftware.petcare.constant.EVax;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ServiceProviderResponse {
    private String profileIdNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private EType type;
    private BigDecimal salary;
    private EVax isVaccinate;
    private Date joinedDate;
    private EStatus status;
    private List<Pet> assignedAnimals;
    private List<VaccinatePoint> vaccinatePoints;
}
