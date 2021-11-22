package com.rentacar.carrental.repositories;

import com.rentacar.carrental.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client,Long> {
}
