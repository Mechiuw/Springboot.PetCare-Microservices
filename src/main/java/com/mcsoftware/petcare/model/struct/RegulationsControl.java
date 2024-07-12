package com.mcsoftware.petcare.model.struct;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public abstract class RegulationsControl {
    public String animalControl(String animal,String staff,String confirmation){
        if (confirmation.isEmpty() || staff.isEmpty()){
            throw new IllegalArgumentException(String.format("can't process an animal without confirmation and staff present: %s",staff));
        }

        return "REGULATED ANIMAL TO BE SHELTERED IN A PERIOD OF TIME UNTIL THERE WILL BE SOMEONE TO ADOPT\n"
                + "\nanimal : " + animal + "\nstaff : " + staff + "\nconfirmation : " + confirmation;
    }
}
