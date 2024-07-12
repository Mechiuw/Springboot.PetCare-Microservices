package com.mcsoftware.petcare.model.struct;

import com.mcsoftware.petcare.constant.EPetBehavior;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Animal {
    private EPetBehavior behavior;

    private EPetBehavior currentBehavior() {
        return this.behavior;
    }
}
