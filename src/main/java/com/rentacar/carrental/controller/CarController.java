package com.rentacar.carrental.controller;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/new")
    public Car addNewCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/show/{id}")
    public Car showCar(@PathVariable("id")Long id){
        return carService.findByCarId(id);
    }

    @GetMapping("/show/all")
    public List<Car> showAllCars(){
        return carService.findAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id")Long id){
        return carService.deleteCarById(id);
    }
}
