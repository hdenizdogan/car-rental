package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

    Client findByUsername(String username);
    List<Client> findAll();
}
