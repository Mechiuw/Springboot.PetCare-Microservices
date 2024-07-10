package com.mcsoftware.petcare.model.struct;

import com.mcsoftware.petcare.constant.EPetBehavior;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Animal {
    public EPetBehavior behavior;

    public EPetBehavior currentBehavior() {
        return this.behavior;
    }
}
