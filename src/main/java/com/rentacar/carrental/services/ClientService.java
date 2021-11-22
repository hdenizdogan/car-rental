package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.repositories.ClientRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClientService{

    @Autowired
    ClientRepository clientRepository;




    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }


    public Client findByClientId(Long clientId) {
        return clientRepository.findById(clientId).stream().findFirst().orElse(null);
    }


    public boolean existsByClientId(Long clientId) {
        return clientRepository.existsById(clientId);
    }


    public List<Client> findAllClients() {
        return (List<Client>) clientRepository.findAll();
    }


    public List<Client> findAllByClientId(List<Long> longs) {
        return (List<Client>) clientRepository.findAllById(longs);
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
