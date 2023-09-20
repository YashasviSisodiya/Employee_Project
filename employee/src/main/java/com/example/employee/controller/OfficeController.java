package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.OfficeDto;
import com.example.employee.entity.Office;
import com.example.employee.service.OfficeService;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;


    @GetMapping("/readOffice/{id}")
    public ResponseEntity<OfficeDto> getOfficeById(@PathVariable("id") Long id){
        OfficeDto office= officeService.getOfficeById(id);
        return new ResponseEntity<>(office, HttpStatus.OK);
    }

    @PostMapping("/insertOffice")
    public ResponseEntity<Office> insertOffice(@RequestBody OfficeDto officeDto){
        Office office= officeService.insertOffice(officeDto);
        return new ResponseEntity<>(office, HttpStatus.OK);
    }


    @PutMapping("/updateOffice/{id}")
    public ResponseEntity<Office> updateOffice(@RequestBody OfficeDto officeDto ,@PathVariable("id") Long id) throws Exception{
        Office office= officeService.updateOffice(officeDto, id);
        return new ResponseEntity<>(office, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOffice/{id}")
    public ResponseEntity<OfficeDto> deleteOffice(@PathVariable("id") Long id){
        officeService.deleteOffice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
