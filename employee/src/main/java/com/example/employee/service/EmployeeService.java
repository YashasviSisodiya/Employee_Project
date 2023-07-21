package com.example.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setDob(employee.getDob());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setGender(employee.getGender());

        return employeeDto;
    }

    public Employee insertEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setDob(employeeDto.getDob());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());

        employee = employeeRepository.save(employee);

        return employee;
    }

    public Employee updateEmployee(EmployeeDto employeeDto, long id) throws Exception{
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setDob(employeeDto.getDob());
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setGender(employeeDto.getGender());

            employee = employeeRepository.save(employee);

            return employee;
        } else{
            throw new Exception("No such employee found");
        }
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }
}
