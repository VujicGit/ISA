package com.isa.user.controller;

import com.isa.user.dto.SearchDermatologistDto;
import com.isa.user.mapper.DermatologistMapper;
import com.isa.user.service.interfaces.IDermatologistService;
import org.apache.coyote.Response;
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
@RequestMapping("/dermatologist")
public class DermatologistController {

    private final IDermatologistService dermatologistService;
    private final DermatologistMapper dermatologistMapper;
    @Autowired
    public DermatologistController(IDermatologistService dermatologistService, DermatologistMapper dermatologistMapper) {
        this.dermatologistService = dermatologistService;
        this.dermatologistMapper  = dermatologistMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<SearchDermatologistDto> dermatologistDtos = dermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.findAllWithPharmacies());
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}/{pharmacyId}/{minGrade}/{maxGrade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@PathVariable String name, @PathVariable String surname, @PathVariable Long pharmacyId, @PathVariable Double minGrade, @PathVariable Double maxGrade) {
        List<SearchDermatologistDto> dermatologistDtos = dermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.filter(name, surname, pharmacyId, minGrade, maxGrade));
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@PathVariable String name, @PathVariable String surname) {
        List<SearchDermatologistDto> dermatologistDtos = dermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.search(name, surname));
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

}
