package com.example.employee.entity;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Office {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name= "CITY")
    private String city;

    @Column(name= "STATE")
    private String state;

    @Column(name= "ZIPCODE")
    private int Zipcode;

    
}
