package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
