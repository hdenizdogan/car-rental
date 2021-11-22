package com.rentacar.carrental.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cars")
public class Car extends BaseEntity{

    @NotBlank
    @Column
    private String brand;

    @NotBlank
    @Column
    private String model;

    @NotBlank
    @Column
    private String type;

    @NotBlank
    @Column
    private String engine;

    @NotBlank
    @Column
    private String year;

    @Column(name = "renter_client_id")
    private Long renterClientId;

    @Column
    @Value(value = "false")
    private boolean rented;


}
