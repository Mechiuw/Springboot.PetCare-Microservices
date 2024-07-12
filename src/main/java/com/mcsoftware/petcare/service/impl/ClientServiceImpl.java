package com.mcsoftware.petcare.service.impl;

import com.mcsoftware.petcare.model.converter.BuilderConverter;
import com.mcsoftware.petcare.model.dto.request.ClientRequest;
import com.mcsoftware.petcare.model.dto.response.ClientResponse;
import com.mcsoftware.petcare.model.entity.Client;
import com.mcsoftware.petcare.model.entity.Pet;
import com.mcsoftware.petcare.repository.ClientRepository;
import com.mcsoftware.petcare.service.interfaces.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final BuilderConverter builderConverter;
    @Override
    public ClientResponse create(ClientRequest clientRequest) {
        try {
            Client convertedClient = builderConverter.clientBuilderConvert(clientRequest);
            Client validatedClient = clientValidator(convertedClient);
            Client savedClient = clientRepository.save(validatedClient);
            return builderConverter.clientResponseBuilder(savedClient);
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found: " + e.getMessage());
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public ClientResponse update(String id, ClientRequest clientRequest) {
        try {
            Client foundClient = clientFinder(id);
            foundClient.setFirstName(clientRequest.getFirstName());
            foundClient.setLastName(clientRequest.getLastName());
            foundClient.setEmail(clientRequest.getEmail());
            foundClient.setAddress(clientRequest.getAddress());
            foundClient.setPhoneNumber(clientRequest.getPhoneNumber());
            foundClient.setStatus(clientRequest.getStatus());
            Client validatedClient = clientValidator(foundClient);
            Client savedClient = clientRepository.save(validatedClient);
            return builderConverter.clientResponseBuilder(savedClient);
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found: " + e.getMessage());
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }

    @Override
    public void delete(String id) {
        try{
            Client foundClient = clientFinder(id);
            if(foundClient != null){
                clientRepository.delete(foundClient);
            } else {
                throw new EntityNotFoundException("not found any client with id : " + id);
            }

        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
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
    public List<Pet> getAllListAdopting(String id) {

        return null;
    }

    @Override
    public Client clientValidator(Client client) {
        try {
            if (client != null && client.getStatus() != null) {
                if (client.getFirstName().isEmpty() || client.getLastName().isEmpty()) {
                    throw new RuntimeException("Missing firstname/lastname is null");
                }
                if (client.getProfileIdNumber().isEmpty()) {
                    throw new RuntimeException("Missing profile id number / is null");
                }
                if (client.getEmail().isEmpty()) {
                    throw new RuntimeException("Missing email / is null");
                }
                if (client.getAddress().isEmpty()) {
                    throw new RuntimeException("Missing address / is null");
                }
                if (client.getPhoneNumber().isEmpty()) {
                    throw new RuntimeException("Missing phone number / is null");
                }
            } else {
                throw new IllegalArgumentException("client can't be null || client status can't be null");
            }
            return client;
        } catch (ValidationException e){
            throw new RuntimeException("validation error : " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute : " + e.getMessage());
        }
    }

    @Override
    public Client clientFinder(String id) {
        try {
            return clientRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any client with id: " + id));
        } catch (EntityNotFoundException e){
            throw new RuntimeException("Entity not found : " + e.getMessage());
        } catch (ValidationException e){
            throw new RuntimeException("Validation Error : " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Failed to execute client finder: " + e.getMessage());
        }
    }
}
