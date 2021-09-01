package com.isa.user.controller;

import com.isa.helper.http.Message;
import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.PharmacyAdministrator;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> process(@RequestBody ProcessVacationRequestDto dto, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {

        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        DermatologistVacationRequest vacationRequest = dermatologistVacationRequestService.process(dto.getId(), dto.getStatus(), dto.getMessage(), pharmacyId);


        return new ResponseEntity<>(new Message("Processed"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(@AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {
        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        List<DermatologistVacationRequest> vacationRequests = dermatologistVacationRequestService.getDermatologistVacationRequestsByPharmacyId(pharmacyId);
        List<VacationRequestDto> dtos = VacationRequestMapper.mapDermatologistVacationRequestsToVacationRequestDtos(vacationRequests);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long id, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {

        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        DermatologistVacationRequest vacationRequest = dermatologistVacationRequestService.getDermatologistVacationRequestById(id);
        return new ResponseEntity<>(VacationRequestMapper.mapDermatologistVacationRequestToVacationRequestDto(vacationRequest), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(value = "/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@PathVariable String name, @PathVariable String surname, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {

        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        List<DermatologistVacationRequest> vacationRequests = dermatologistVacationRequestService.filter(pharmacyId, name, surname, VacationRequestStatus.CREATED);
        return new ResponseEntity<>(VacationRequestMapper.mapDermatologistVacationRequestsToVacationRequestDtos(vacationRequests), HttpStatus.OK);
    }
}
