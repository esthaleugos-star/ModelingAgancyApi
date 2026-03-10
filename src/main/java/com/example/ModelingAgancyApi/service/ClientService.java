package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    Client updateClient(Long id, Client clientDetails);
    void deleteClient(Long id);
    void assignProductToClient(Long clientId, Long productId);
}