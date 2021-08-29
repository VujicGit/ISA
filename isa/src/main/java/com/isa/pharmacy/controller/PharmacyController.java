package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;
import com.isa.pharmacy.mapper.PharmacyMapper;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    private final IPharmacyService pharmacyService;

    @Autowired
    public PharmacyController(IPharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Pharmacy> pharmacies = pharmacyService.findAll();
        List<PharmacyDto> dtos = PharmacyMapper.mapPharmaciesToPharmacyDtos(pharmacies);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
