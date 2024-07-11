package com.mcsoftware.petcare.model.dto.request;

import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.constant.EType;
import com.mcsoftware.petcare.constant.EVax;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ServiceProviderRequest {
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
}
