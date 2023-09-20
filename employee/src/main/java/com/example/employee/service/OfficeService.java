package com.example.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.OfficeDto;
import com.example.employee.entity.Office;
import com.example.employee.repository.OfficeRepository;
@Service
public class OfficeService {
    @Autowired
    OfficeRepository officeRepository;

    public OfficeDto getOfficeById(Long id){
        Office office = officeRepository.getReferenceById(id);
        
        OfficeDto officeDto= new OfficeDto();
        officeDto.setAddress(office.getAddress());
        officeDto.setCity(office.getCity());
        officeDto.setState(office.getState());
        officeDto.setZipcode(office.getZipcode());
    
        return officeDto;
    }

    public Office insertOffice(OfficeDto officeDto){
        Office office= new Office();
        office.setId(officeDto.getId());
        office.setAddress(officeDto.getAddress());
        office.setCity(officeDto.getCity());
        office.setState(officeDto.getState());
        office.setZipcode(officeDto.getZipcode());

        office = officeRepository.save(office);

        return office;
    }

    public Office updateOffice(OfficeDto officeDto, long id) throws Exception{
        Optional<Office> officeOptional = officeRepository.findById(id);
        
        if(officeOptional.isPresent()){
            Office office = officeOptional.get();
            office.setAddress(officeDto.getAddress());
            office.setCity(officeDto.getCity());
            office.setState(officeDto.getState());
            office.setZipcode(officeDto.getZipcode());

            office = officeRepository.save(office);

            return office;
        } else{
            throw new Exception("No such Office_id found");
        }
    }

    public void deleteOffice(long id){
        officeRepository.deleteById(id);
    }
}
