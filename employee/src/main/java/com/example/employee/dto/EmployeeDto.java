package com.example.employee.dto;

import java.util.Date;
import com.example.employee.entity.Office;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private char gender;
    private Date dob;
    private Office office;
}
