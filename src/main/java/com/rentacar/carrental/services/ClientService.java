package com.rentacar.carrental.services;


import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }


    public Client findByClientId(Long clientId) {
        return clientRepository.findById(clientId).stream().findFirst().orElse(null);
    }

    public Client findClientByUsername(String username){
        return clientRepository.findByUsername(username);
    }


    public boolean existsByClientId(Long clientId) {
        return clientRepository.existsById(clientId);
    }


    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }


    public List<Client> findAllByClientId(List<Long> clientIds) {
        return (List<Client>) clientRepository.findAllById(clientIds);
    }


    public long countClients() {
        return clientRepository.count();
    }


    public void deleteByClientId(Long clientId) {
        clientRepository.deleteById(clientId);
    }


    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }


    public void deleteAllByClientId(Iterable<Long> longs) {
        clientRepository.deleteAllById(longs);
    }


    public void deleteAllClients(Iterable<Client> clients) {
        clientRepository.deleteAll(clients);
    }


    public void deleteAllClients() {
        clientRepository.deleteAll();
    }
}
