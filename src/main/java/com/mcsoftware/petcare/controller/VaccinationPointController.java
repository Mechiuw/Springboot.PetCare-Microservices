package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.VaccinatePointRequest;
import com.mcsoftware.petcare.model.dto.response.RegulationsResponse;
import com.mcsoftware.petcare.model.dto.response.VaccinatePointResponse;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.service.interfaces.VaccinationPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Endpoint.VACCINATE)
public class VaccinationPointController {
    private final VaccinationPointService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VaccinatePointRequest request){
        VaccinatePointResponse response = service.create(request);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created data",
                        response
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody VaccinatePointRequest request){
        VaccinatePointResponse response = service.update(id,request);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully updated data",
                        response
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping(Endpoint.DELETE_ID)
    public ResponseEntity<?> delete(@PathVariable String id){
        service.delete(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully deleted data",
                        "deleted vp with id : " + id
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        VaccinatePointResponse response = service.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch data",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<VaccinatePoint> response = service.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch data",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> regulations(@PathVariable String id){
        RegulationsResponse response = service.regulations(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created regulations",
                        response
                ),
                HttpStatus.OK
        );
    }
}
