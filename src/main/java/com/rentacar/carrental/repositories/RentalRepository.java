package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Rental;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RentalRepository extends PagingAndSortingRepository<Rental,Long> {
}
