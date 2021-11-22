package com.rentacar.carrental.services;

import com.rentacar.carrental.model.Car;
import com.rentacar.carrental.model.Client;
import com.rentacar.carrental.model.Rental;
import com.rentacar.carrental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Rental findByRentalId(Long rentalId) {
        return rentalRepository.findById(rentalId).stream().findFirst().orElse(null);
    }

    public void deleteByRentalId(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId).stream().findFirst().orElse(null);
        Long carId = rental.getRentedCarId();
        Long clientId = rental.getRenterClientId();
        Car car = carService.findByCarId(carId);
        Client client = clientService.findByClientId(clientId);
        car.setRenterClientId(null);
        client.setRentedCarId(null);
        car.setRented(false);
        rentalRepository.deleteById(rentalId);
    }

    public Iterable<Rental> findAll() {
        return rentalRepository.findAll();
    }
}
