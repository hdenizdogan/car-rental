package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.repositories.ClientRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService{

    @Autowired
    ClientRepository clientRepository;



    public Iterable<Client> findAll(Sort sort) {
        return clientRepository.findAll(sort);
    }


    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }


    public Client save(Client client) {
        return clientRepository.save(client);
    }


    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }


    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }


    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }


    public Iterable<Client> findAllById(Iterable<Long> longs) {
        return clientRepository.findAllById(longs);
    }


    public long count() {
        return clientRepository.count();
    }


    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }


    public void delete(Client client) {
        clientRepository.delete(client);
    }


    public void deleteAllById(Iterable<Long> longs) {
        clientRepository.deleteAllById(longs);
    }


    public void deleteAll(Iterable<Client> entities) {
        clientRepository.deleteAll(entities);
    }


    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
