package com.example.employee.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name= "LAST_NAME")
    private String lastName;

    @Column(name= "GENDER")
    private char gender;

    @Column(name= "DOB")
    private Date dob;
}
