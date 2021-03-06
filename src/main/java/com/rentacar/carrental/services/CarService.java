package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService{

    @Autowired
    CarRepository carRepository;

    public Car saveCar(Car car){
        return carRepository.save(car);
    }


    public Car findByCarId(Long carId) {
        return carRepository.findById(carId).stream().findFirst().orElse(null);
    }

    public List<Car> findAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public String deleteCarById(Long id){
        if (findByCarId(id) != null){
            carRepository.deleteById(id);
            return "Car with the id: "+id+" has been deleted.";
        }
        return "No such car with the id: "+id+" is found";
    }



}
