package com.mcsoftware.petcare.controller;
import com.mcsoftware.petcare.app.Endpoint;
import com.mcsoftware.petcare.model.dto.API.CommonResponse;
import com.mcsoftware.petcare.model.dto.request.ClientRequest;
import com.mcsoftware.petcare.model.dto.response.ClientResponse;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(Endpoint.CLIENT)
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientRequest clientRequest) {
        ClientResponse create = clientService.create(clientRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created client",
                        create),
                HttpStatus.CREATED
        );
    }
    @PutMapping(Endpoint.PUT_ID)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ClientRequest clientRequest) {
        ClientResponse update = clientService.update(id, clientRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully updated client",
                        update),
                HttpStatus.OK
        );
    }
    @DeleteMapping(Endpoint.DELETE_ID)
    public ResponseEntity<?> delete(@PathVariable String id) {
        clientService.delete(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully deleted client",
                        "deleted with id : " + id),
                HttpStatus.OK
        );
    }
    @GetMapping(Endpoint.GET_ID)
    public ResponseEntity<?> getById(@PathVariable String id){
        ClientResponse response = clientService.getById(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch client",
                        response),
                HttpStatus.OK
        );
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Client> clients = clientService.getAll();
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch clients",
                        clients
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(Endpoint.ALL_ADOPT_ID)
    public ResponseEntity<?> getAllListAdopting(@PathVariable String id){
        List<Pet> pets = clientService.getAllListAdopting(id);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.OK.value(),
                        "successfully fetch pets",
                        pets
                ),
                HttpStatus.OK
        );
    }
}
