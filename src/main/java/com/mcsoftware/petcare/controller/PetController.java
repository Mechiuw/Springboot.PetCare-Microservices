package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.PetRequest;
import com.mcsoftware.petcare.model.dto.response.PetResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.service.interfaces.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.PET)
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PetRequest petRequest){
        PetResponse response = petService.create(petRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created pet",
                        response
                ),
                HttpStatus.CREATED
        );
    }
    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody PetRequest petRequest){
        PetResponse response = petService.update(id,petRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated pet",
                        response
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping(Endpoint.DELETE_ID)
    public ResponseEntity<?> delete(@PathVariable String id){
        petService.delete(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully deleted pet",
                        "deleted pet with id : " + id
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        PetResponse response = petService.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch pet",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Pet> pets = petService.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch all pets",
                        pets
                ),
                HttpStatus.OK
        );
    }


    public ResponseEntity<?> petBoarding(){}
    public ResponseEntity<?> getPetMedicalConditions(){}
}
