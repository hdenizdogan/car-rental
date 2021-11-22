package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car,Long> {
}
