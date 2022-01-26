package com.rentacar.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "clients")
public class Client extends Person{
    @NotBlank
    @Column(name = "licence_number",unique = true)
    @Size(min=6,max=6)
    private Long licenceNumber;

    @Column(name = "rented_car_id")
    private Long rentedCarId;
}
