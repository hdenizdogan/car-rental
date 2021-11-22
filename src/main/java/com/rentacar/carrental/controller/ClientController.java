package com.rentacar.carrental.controller;


import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;



    @GetMapping("/show/{id}")
    public Optional<Client> showClientData(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @PostMapping("/new")
    public Client addNewClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/show/all")
    public Iterable<Client> showAllClients(){
        return clientService.findAll();
    }
}
