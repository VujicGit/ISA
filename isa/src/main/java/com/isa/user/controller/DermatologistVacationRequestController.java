package com.isa.user.controller;

import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.enumeration.VacationRequestStatus;
import com.isa.user.dto.ProcessVacationRequestDto;
import com.isa.user.dto.VacationRequestDto;
import com.isa.user.mapper.VacationRequestMapper;
import com.isa.user.service.interfaces.IDermatologistVacationRequestService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isa.helper.error.Error;

import java.util.List;

@RestController
@RequestMapping("/dermatologistVacationRequest")
public class DermatologistVacationRequestController {

    private final IDermatologistVacationRequestService dermatologistVacationRequestService;

    @Autowired
    public DermatologistVacationRequestController(IDermatologistVacationRequestService dermatologistVacationRequestService) {
        this.dermatologistVacationRequestService = dermatologistVacationRequestService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> process(@RequestBody ProcessVacationRequestDto dto) {

        DermatologistVacationRequest vacationRequest = dermatologistVacationRequestService.process(dto.getId(), dto.getStatus());

        if (vacationRequest == null)
            return new ResponseEntity<>(new Error("Vacation request is already processed"), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("Processed", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        Long pharmacyId = 1L; //get from jwt
        List<DermatologistVacationRequest> vacationRequests = dermatologistVacationRequestService.getDermatologistVacationRequestsByPharmacyId(pharmacyId);
        List<VacationRequestDto> dtos = VacationRequestMapper.mapDermatologistVacationRequestsToVacationRequestDtos(vacationRequests);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Long pharmacyId = 1L; //get from jwt
        DermatologistVacationRequest vacationRequest = dermatologistVacationRequestService.getDermatologistVacationRequestById(id);
        return new ResponseEntity<>(VacationRequestMapper.mapDermatologistVacationRequestToVacationRequestDto(vacationRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@PathVariable String name, @PathVariable String surname) {

        Long pharmacyId = 1L;
        List<DermatologistVacationRequest> vacationRequests = dermatologistVacationRequestService.filter(pharmacyId, name, surname, VacationRequestStatus.CREATED);
        return new ResponseEntity<>(VacationRequestMapper.mapDermatologistVacationRequestsToVacationRequestDtos(vacationRequests), HttpStatus.OK);
    }
}
