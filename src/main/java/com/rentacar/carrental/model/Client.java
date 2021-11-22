package com.rentacar.carrental.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "clients")
public class Client extends Person{

    @NotBlank
    @Column(name = "licence_number")
    @Size(min=6,max=6)
    private String licenceNumber;

    @Column(name = "rented_car_id")
    private Long rentedCarId;
}
