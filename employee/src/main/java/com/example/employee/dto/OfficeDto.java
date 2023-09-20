package com.example.employee.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfficeDto {
    private Integer id;
    private String address;
    private String city;
    private String state;
    private int Zipcode;

}
