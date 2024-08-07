package com.mcsoftware.petcare.service.interfaces;
import com.mcsoftware.petcare.model.dto.request.VaccinatePointRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.VaccinatePointResponse;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import java.util.List;

public interface VaccinationPointService {

    //CRUD
    VaccinatePointResponse create(VaccinatePointRequest vaccinatePointRequest);
    VaccinatePointResponse update(String id,VaccinatePointRequest vaccinatePointRequest);
    void delete(String id);
    VaccinatePointResponse getById(String id);
    List<VaccinatePoint> getAll();

    //REGULATIONS
    RegulationsResponse regulations(String id);

    //FINDER, VALIDATOR
    VaccinatePoint vpFinder(String id);
    VaccinatePoint vpValidator(VaccinatePoint vaccinatePoint);
}
