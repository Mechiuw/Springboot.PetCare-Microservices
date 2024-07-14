package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.ShelterRequest;
import com.mcsoftware.petcare.model.dto.response.ShelterResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.Shelter;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.service.interfaces.ShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody ShelterRequest shelterRequest){
        ShelterResponse response = service.update(id,shelterRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully updated shelter",
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
                        "successfully delete shelter",
                        "deleted shelter with id : " + id
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        ShelterResponse response = service.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch shelter",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Shelter> response = service.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch all shelter",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.PET_SHELTER_ID)
    public ResponseEntity<?> getAllPetinShelter(@PathVariable String id){
        List<Pet> response = service.getAllPetInShelter(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch all pet",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.VAX_SHELTER_ID)
    public ResponseEntity<?> getVaccinatePointList(@PathVariable String id){
        List<VaccinatePoint> response = service.getVaccinatePointList(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch all vaccination",
                        response
                ),
                HttpStatus.OK
        );
    }
}
