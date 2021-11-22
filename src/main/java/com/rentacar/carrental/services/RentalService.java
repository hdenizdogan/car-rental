package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.model.Rental;
import com.rentacar.carrental.repositories.CarRepository;
import com.rentacar.carrental.repositories.ClientRepository;
import com.rentacar.carrental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    public Rental save(Rental rental){
        Long carId = rental.getRentedCarId();
        Long clientId = rental.getRenterClientId();
        Optional<Car> car = carRepository.findById(carId);
        Optional<Client> client = clientRepository.findById(clientId);
        if(car.isPresent() && client.isPresent()) {
            car.get().setRenterClientId(clientId);
            client.get().setRentedCarId(carId);
            car.get().setRented(true);
            carRepository.save(car.get());
            clientRepository.save(client.get());
            return rentalRepository.save(rental);
        }
        throw new NullPointerException();
    }

    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    public void deleteById(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        if(rental.isPresent()){
            Long carId = rental.get().getRentedCarId();
            Long clientId = rental.get().getRenterClientId();
            Optional<Car> car = carRepository.findById(carId);
            Optional<Client> client = clientRepository.findById(clientId);
            if(car.isPresent() && client.isPresent()){
                car.get().setRenterClientId(null);
                client.get().setRentedCarId(null);
                car.get().setRented(false);
                rentalRepository.deleteById(id);
            }
        }
    }

    public Iterable<Rental> findAll() {
        return rentalRepository.findAll();
    }
}
