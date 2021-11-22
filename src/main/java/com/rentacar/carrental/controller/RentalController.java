package com.rentacar.carrental.controller;


import com.rentacar.carrental.model.Rental;
import com.rentacar.carrental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Rental rental = rentalService.findByRentalId(rentalId);
        rentalService.deleteByRentalId(rentalId);
        return "Deleted "+rentalId;
    }
}
