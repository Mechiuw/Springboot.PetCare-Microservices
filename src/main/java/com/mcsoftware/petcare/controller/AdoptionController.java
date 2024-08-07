package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.model.entity.Adoption;
import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.ADOPTION)
@RequiredArgsConstructor
public class AdoptionController {
    private final AdoptionService adoptionService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AdoptionRequest adoptionRequest) throws IllegalAccessException {
        AdoptionResponse createResponse = adoptionService.create(adoptionRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created adoption",
                        createResponse
                ),
                HttpStatus.OK
        );
    }

    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdoptionRequest adoptionRequest){
        AdoptionResponse updateResponse = adoptionService.update(id,adoptionRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully updated adoption",
                        updateResponse
                ),
                HttpStatus.OK
        );
    }

    @PutMapping(Endpoint.SOFT_DEL_ID)
    public ResponseEntity<?> softDelete(@PathVariable String id){
        AdoptionResponse response = adoptionService.softDelete(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully soft delete adoption",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        AdoptionResponse response = adoptionService.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch adoption",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Adoption> adoptionList = adoptionService.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch adoptions",
                        adoptionList
                ),
                HttpStatus.OK
        );
    }
}
