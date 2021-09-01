package com.isa.user.controller;

import com.isa.helper.http.Message;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.dto.EmploymentDto;
import com.isa.user.service.interfaces.IEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employment")
public class EmploymentController {

    private final IEmploymentService employmentService;

    @Autowired
    public EmploymentController(IEmploymentService employmentService) {
        this.employmentService = employmentService;
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @PostMapping(value = "/dermatologist",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> employDermatologist(@RequestBody EmploymentDto dto, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {
        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        employmentService.employDermatologist(dto.getDermatologistId(), pharmacyId, dto.getShiftDtos());
        return new ResponseEntity<>(new Message("Success"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @DeleteMapping(value = "/dermatologistId/{dermatologistId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeDermatologistFromPharmacy(@PathVariable Long dermatologistId, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {
        Long pharmacyId = pharmacyAdmin.getPharmacyId();

        employmentService.removeDermatologistFromPharmacy(dermatologistId, pharmacyId);
        return new ResponseEntity<>(new Message("Success"), HttpStatus.OK);
    }

}
