package com.mcsoftware.petcare.model.dto.response;

import com.mcsoftware.petcare.constant.EPetBehavior;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BehaviorResponse {
    private String petId;
    private EPetBehavior petBehavior;
    private String message;
}
