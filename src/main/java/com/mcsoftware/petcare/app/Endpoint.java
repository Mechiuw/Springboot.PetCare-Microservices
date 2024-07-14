package com.mcsoftware.petcare.app;

public class Endpoint {
    public static final String API = "/api";

    public static final String CLIENT = API + "/client";
    public static final String PET = API + "/pet";
    public static final String SHELTER = API + "/shelter";
    public static final String WILD_ANIMAL = API + "/wild-animal";
    public static final String SERVICE_PROVIDER = API + "/service-provider";
    public static final String VACCINATE = API + "/vaccination";
    public static final String ADOPTION = API + "/adoption";
    public static final String ADOPTION_DETAIL = API + "/adoption-detail";
    public static final String REGULATIONS = API + "/regulations";
    public static final String BOARDING_PET = "/boarding";
    public static final String ALL_ASSIGNED = "/all/assigned";
    public static final String ALL_VP = "/all/vaccination";

    public static final String PUT_ID = "/{id}";
    public static final String DELETE_ID = "/{id}";
    public static final String GET_ID = "/{id}";

    public static final String ALL_ADOPT_ID = "/all/adopt/{id}";
    public static final String SOFT_DEL_ID = "/soft/del/{id}";
    public static final String MEDS_ID = "/medical/conditions/{id}";
    public static final String EVAX_ID = "/evax/{id}";
    public static final String PET_SHELTER_ID = "/pet-shl/{id}";
    public static final String VAX_SHELTER_ID = "/vax-shl/{id}";
    public static final String ANIMAL_VAX_ID = "/animal/vax/{id}";
}
