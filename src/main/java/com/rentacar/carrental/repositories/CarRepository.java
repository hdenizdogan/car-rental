package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
