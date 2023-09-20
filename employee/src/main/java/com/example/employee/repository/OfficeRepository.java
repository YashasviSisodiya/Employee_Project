package com.example.employee.repository;

import org.springframework.stereotype.Repository;

import com.example.employee.entity.Office;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    
}
