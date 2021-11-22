package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Rental;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends PagingAndSortingRepository<Rental,Long> {

}
