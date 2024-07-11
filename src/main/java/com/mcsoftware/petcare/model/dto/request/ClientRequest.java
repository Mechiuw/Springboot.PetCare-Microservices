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
public class ClientRequest {
    private String firstName;
    private String lastName;
    private String profileIdNumber;
    private String email;
    private String address;
    private String phoneNumber;
    private EStatus status;
}
