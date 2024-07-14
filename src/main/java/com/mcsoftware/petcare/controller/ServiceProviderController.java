package com.mcsoftware.petcare.controller;

import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.ServiceProviderRequest;
import com.mcsoftware.petcare.model.dto.response.ServiceProviderResponse;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.model.entity.ServiceProvider;
import com.mcsoftware.petcare.model.entity.VaccinatePoint;
import com.mcsoftware.petcare.service.interfaces.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.bytecode.enhance.spi.interceptor.AbstractLazyLoadInterceptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.SERVICE_PROVIDER)
@RequiredArgsConstructor
public class ServiceProviderController {
    private final ServiceProviderService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServiceProviderRequest serviceProviderRequest){
        ServiceProviderResponse response = service.create(serviceProviderRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully create service provider",
                        response
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody ServiceProviderRequest serviceProviderRequest){
        ServiceProviderResponse response = service.update(id,serviceProviderRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping(Endpoint.DELETE_ID)
    public ResponseEntity<?> delete(String id){
        service.delete(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        "deleted service provider : " + id
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(String id){
        ServiceProviderResponse response = service.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ServiceProvider> response = service.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.ALL_ASSIGNED)
    public ResponseEntity<?> getAllAssignedAnimals(String id){
        List<Pet> response = service.getAllAssignedAnimals(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.ALL_VP)
    public ResponseEntity<?> getAllVaccinatePoints(String id){
        List<VaccinatePoint> response = service.getAllVaccinatePoints(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.EVAX_ID)
    public ResponseEntity<?> eVaxDose(){

        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated service provider",
                        response
                ),
                HttpStatus.OK
        );
    }
}
