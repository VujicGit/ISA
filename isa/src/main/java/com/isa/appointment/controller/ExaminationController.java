package com.isa.appointment.controller;

import com.isa.appointment.dto.ExaminationDto;
import com.isa.appointment.service.interfaces.IExaminationService;
import com.isa.helper.http.Message;
import com.isa.user.domain.PharmacyAdministrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    private final IExaminationService examinationService;

    @Autowired
    public ExaminationController(IExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @PostMapping(value = "/define", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> define(@RequestBody ExaminationDto dto, @AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {
        Long pharmacyId = pharmacyAdmin.getPharmacyId();

        examinationService.define(pharmacyId, dto);

        return new ResponseEntity<>(new Message("Success"), HttpStatus.CREATED);
    }
}
