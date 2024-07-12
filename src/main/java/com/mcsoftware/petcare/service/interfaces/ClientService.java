package com.mcsoftware.petcare.service.interfaces;
import com.mcsoftware.petcare.model.dto.request.ClientRequest;
import com.mcsoftware.petcare.model.dto.response.ClientResponse;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Pet;
import java.util.List;

public interface ClientService {
    //CRUD
    ClientResponse create(ClientRequest clientRequest);
    ClientResponse update(String id, ClientRequest clientRequest);
    void delete(String id);
    ClientResponse getById(String id);
    List<Client> getAll();
    List<Pet> getAllListAdopting(String id);
    //FINDER
    Client clientFinder(String id);
    //VALIDATOR
    Client clientValidator(Client client);
}
