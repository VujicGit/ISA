package com.isa.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.DermatologistDto;
import com.isa.user.mapper.DermatologistMapper;
import com.isa.user.service.interfaces.IDermatologistService;
import netscape.javascript.JSObject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        List<DermatologistDto> dermatologistDtos = dermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.findAll());
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }
}
