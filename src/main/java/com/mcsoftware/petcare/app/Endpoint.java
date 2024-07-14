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
    public static final String BOARDING_PET = "/boarding-pet";

    public static final String PUT_ID = "/{id}";
    public static final String DELETE_ID = "/{id}";
    public static final String GET_ID = "/{id}";

    public static final String ALL_ADOPT_ID = "/all-adopt/{id}";
    public static final String SOFT_DEL_ID = "/soft-del/{id}";
    public static final String MEDS_ID = "/medical-conditions/{id}";
}
