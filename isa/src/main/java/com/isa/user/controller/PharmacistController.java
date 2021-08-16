package com.isa.user.controller;

import com.isa.user.dto.SearchPharmacistDto;
import com.isa.user.mapper.PharmacistMapper;
import com.isa.user.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pharmacist")
public class PharmacistController {

    private final IPharmacistService pharmacistService;

    @Autowired
    public PharmacistController(IPharmacistService pharmacistService) {
        this.pharmacistService = pharmacistService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<SearchPharmacistDto> searchPharmacistDtos = PharmacistMapper.mapPharmacistsToSearchPharmacistDtos(pharmacistService.findAllWithPharmacies());
        return new ResponseEntity<>(searchPharmacistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@PathVariable String name, @PathVariable String surname) {
        List<SearchPharmacistDto> searchPharmacistDtos = PharmacistMapper.mapPharmacistsToSearchPharmacistDtos(pharmacistService.search(name, surname));
        return new ResponseEntity<>(searchPharmacistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}/{pharmacyId}/{minGrade}/{maxGrade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@PathVariable String name, @PathVariable String surname, @PathVariable Long pharmacyId, @PathVariable Double minGrade, @PathVariable Double maxGrade) {
        List<SearchPharmacistDto> searchPharmacistDtos = PharmacistMapper.mapPharmacistsToSearchPharmacistDtos(pharmacistService.filter(name, surname, pharmacyId, minGrade, maxGrade));
        return new ResponseEntity<>(searchPharmacistDtos, HttpStatus.OK);
    }
}
