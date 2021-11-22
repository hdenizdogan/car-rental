package com.rentacar.carrental.controller;


import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;



    @GetMapping("/show/{id}")
    public Client showClientData(@PathVariable("id") Long clientId){
        return clientService.findByClientId(clientId);
    }

    @PostMapping("/new")
    public Client addNewClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @GetMapping("/show/all")
    public List<Client> showAllClients(){
        return clientService.findAllClients();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteByClientId(id);
    }
}
