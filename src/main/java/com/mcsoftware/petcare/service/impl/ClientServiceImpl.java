package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.dto.request.ClientRequest;
import com.mcsoftware.petcare.model.dto.response.ClientResponse;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.service.interfaces.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public ClientResponse create(ClientRequest clientRequest) {
        return null;
    }

    @Override
    public ClientResponse update(String id, ClientRequest clientRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ClientResponse getById(String id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public List<Pet> getAllListAdopting() {
        return null;
    }

    @Override
    public Client clientValidator(Client client) {
        if(client != null && client.getStatus() != null) {
            if(client.getFirstName().isEmpty() || client.getLastName().isEmpty()){
                throw new RuntimeException("Missing firstname/lastname is null");
            }
            if(client.getProfileIdNumber().isEmpty()){
                throw new RuntimeException("Missing profile id number / is null");
            }
            if(client.getEmail().isEmpty()){
                throw new RuntimeException("Missing email / is null");
            }
            if(client.getAddress().isEmpty()){
                throw new RuntimeException("Missing address / is null");
            }
            if(client.getPhoneNumber().isEmpty()){
                throw new RuntimeException("Missing phone number / is null");
            }
        } else {
            throw new IllegalArgumentException("client can't be null || client status can't be null");
        }
        return client;
    }
}
