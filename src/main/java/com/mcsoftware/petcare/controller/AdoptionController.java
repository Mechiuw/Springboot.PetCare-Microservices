package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.AdoptionRequest;
import com.mcsoftware.petcare.model.dto.response.AdoptionResponse;
import com.mcsoftware.petcare.service.interfaces.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
