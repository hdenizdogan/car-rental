package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CarService{

    @Autowired
    CarRepository carRepository;

    public Car save(Car car){
        return carRepository.save(car);
    }


    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

}
