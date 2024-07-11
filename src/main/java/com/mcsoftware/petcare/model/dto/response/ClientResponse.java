package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.constant.EStatus;
import com.mcsoftware.petcare.model.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ClientResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String profileIdNumber;
    private String email;
    private String address;
    private String phoneNumber;
    private EStatus status;
    private List<Pet> listAdopting;
}
