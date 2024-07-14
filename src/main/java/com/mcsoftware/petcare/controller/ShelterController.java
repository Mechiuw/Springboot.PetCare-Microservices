package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.ShelterRequest;
import com.mcsoftware.petcare.model.dto.response.ShelterResponse;
import com.mcsoftware.petcare.service.interfaces.ShelterService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.SHELTER)
@RequiredArgsConstructor
public class ShelterController {
    private final ShelterService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ShelterRequest shelterRequest){
        ShelterResponse response = service.create(shelterRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created shelter",
                        response
                ),
                HttpStatus.OK
        );
    }
    public ResponseEntity<?> update(String id,ShelterRequest shelterRequest){}
    public ResponseEntity<?> delete(String id){}
    public ResponseEntity<?> getById(String id){}
    public ResponseEntity<?> getAll(){}
    public ResponseEntity<?> getAllPetinShelter(String id){}
    public ResponseEntity<?> getVaccinatePointList(String id){}
}
