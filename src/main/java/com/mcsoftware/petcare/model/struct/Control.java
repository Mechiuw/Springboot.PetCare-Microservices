package com.mcsoftware.petcare.model.struct;


public abstract class Control {
    public String animalControl(String animal,String staff,String confirmation){
        if (confirmation.isEmpty() || staff.isEmpty()){
            throw new IllegalArgumentException(String.format("can't process an animal without confirmation and staff present: %s",staff));
        }

        String regulated = "REGULATED ANIMAL TO BE SHELTERED IN A PERIOD OF TIME UNTIL THERE WILL BE SOMEONE TO ADOPT\n"
                + "\nanimal : " + animal + "\nstaff : " + staff + "\nconfirmation : " + confirmation;
        return regulated;
    }
}
