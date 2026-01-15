package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Client;
import com.example.ModelingAgancyApi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            // 📝 Matching your Client.java fields exactly:
            client.setCompanyName(clientDetails.getCompanyName());
            client.setContactPerson(clientDetails.getContactPerson());
            client.setPhone(clientDetails.getPhone());
            client.setEmail(clientDetails.getEmail());
            client.setAddress(clientDetails.getAddress());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}