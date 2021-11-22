package com.rentacar.carrental.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "rentals")
public class Rental extends BaseEntity{

    @NotNull
    @Column(name = "rented_car_id")
    private Long rentedCarId;

    @NotNull
    @Column(name = "renter_client_id")
    private Long renterClientId;
}
