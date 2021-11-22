package com.rentacar.carrental.controller;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/new")
    public Car addNewCar(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/show/{id}")
    public Optional<Car> showCar(@PathVariable("id")Long id){
        return carService.findById(id);
    }

    @GetMapping("/show/all")
    public Iterable<Car> showAllCars(){
        return carService.findAll();
    }
}
