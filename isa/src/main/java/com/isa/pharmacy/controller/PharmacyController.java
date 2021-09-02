package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;
import com.isa.pharmacy.mapper.PharmacyMapper;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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

    @GetMapping(value = "/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long pharmacyId) {
        Pharmacy pharmacy = pharmacyService.findById(pharmacyId);
        PharmacyDto pharmacyDto = PharmacyMapper.mapPharmacyToPharmacyDto(pharmacy);
        return new ResponseEntity<>(pharmacyDto, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateInfo(@RequestBody PharmacyDto pharmacyDto) {
        pharmacyService.update(pharmacyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
