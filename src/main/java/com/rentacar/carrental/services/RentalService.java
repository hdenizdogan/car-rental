package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.model.Rental;
import com.rentacar.carrental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CarService carService;

    @Autowired
    ClientService clientService;

    public Rental save(Rental rental){
        Long carId = rental.getRentedCarId();
        Long clientId = rental.getRenterClientId();
        Car car = carService.findByCarId(carId);
        Client client = clientService.findByClientId(clientId);
            car.setRenterClientId(clientId);
            client.setRentedCarId(carId);
            car.setRented(true);
            carService.saveCar(car);
            clientService.saveClient(client);
            return rentalRepository.save(rental);

    }

    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    public void deleteById(Long id) {
        Rental rental = rentalRepository.findById(id).stream().findFirst().orElse(null);
        Long carId = rental.getRentedCarId();
        Long clientId = rental.getRenterClientId();
        Car car = carService.findByCarId(carId);
        Client client = clientService.findByClientId(clientId);
        car.setRenterClientId(null);
        client.setRentedCarId(null);
        car.setRented(false);
        rentalRepository.deleteById(id);
    }

    public Iterable<Rental> findAll() {
        return rentalRepository.findAll();
    }
}
