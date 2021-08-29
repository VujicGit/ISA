package com.isa.user.controller;

import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.dto.SearchDermatologistDto;
import com.isa.user.mapper.DermatologistMapper;
import com.isa.user.service.interfaces.IDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dermatologist")
public class DermatologistController {

    private final IDermatologistService dermatologistService;

    @Autowired
    public DermatologistController(IDermatologistService dermatologistService) {
        this.dermatologistService = dermatologistService;
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {

        PharmacyAdministrator administrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(administrator.getPharmacyId());
        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.findAllWithPharmacies());
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}/{pharmacyId}/{minGrade}/{maxGrade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@PathVariable String name, @PathVariable String surname, @PathVariable Long pharmacyId, @PathVariable Double minGrade, @PathVariable Double maxGrade) {
        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.filter(name, surname, pharmacyId, minGrade, maxGrade));
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@PathVariable String name, @PathVariable String surname) {
        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.search(name, surname));
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

}
