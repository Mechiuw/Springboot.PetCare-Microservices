package com.mcsoftware.petcare.controller;


import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.VaccinatePointRequest;
import com.mcsoftware.petcare.model.dto.request.WildAnimalRequest;
import com.mcsoftware.petcare.model.dto.response.VaccinatePointResponse;
import com.mcsoftware.petcare.model.dto.response.WildAnimalResponse;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.model.entity.WildAnimal;
import com.mcsoftware.petcare.service.interfaces.WildAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Endpoint.WILD_ANIMAL)
public class WildAnimalController {
    private final WildAnimalService service;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody WildAnimalRequest request){
        WildAnimalResponse response = service.create(request);
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
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody WildAnimalRequest request){
        WildAnimalResponse response = service.update(id,request);
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
                        "deleted wild animal with id : " + id
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        WildAnimalResponse response = service.getById(id);
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
        List<WildAnimal> response = service.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully fetch data",
                        response
                ),
                HttpStatus.OK
        );
    }


}
