package com.rentacar.carrental.controller;


import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.model.Rental;
import com.rentacar.carrental.services.CarService;
import com.rentacar.carrental.services.ClientService;
import com.rentacar.carrental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    RentalService rentalService;


    @GetMapping("/show/all")
    public Iterable<Rental> showAllRentals(){
        return rentalService.findAll();
    }

    @PostMapping({"/",""})
    public Rental rentACar(@RequestBody Rental rental){
        return rentalService.save(rental);
    }

    @GetMapping("/delivering/{id}")
    public String deliverACar(@PathVariable("id")Long rentalId){
        Optional<Rental> rental = rentalService.findById(rentalId);
        rentalService.deleteById(rentalId);
        return "Deleted "+rentalId;
    }
}
