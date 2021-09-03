package com.isa.user.controller;

import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.dto.FilterDto;
import com.isa.user.dto.SearchDermatologistDto;
import com.isa.user.dto.SearchDto;
import com.isa.user.mapper.DermatologistMapper;
import com.isa.user.service.interfaces.IDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {

        List<Dermatologist> dermatologists = dermatologistService.findAllWithPharmacies();
        List<SearchDermatologistDto> dtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologists);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }



    @GetMapping(value = "/pharmacyId/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllForPharmacy(@PathVariable Long pharmacyId) {

        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologistService.findAllByPharmacyId(pharmacyId));
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@RequestBody FilterDto dto) {
        List<Dermatologist> dermatologists = dermatologistService.filter(dto.getName(), dto.getSurname(), dto.getPharmacyId(), dto.getMinGrade(), dto.getMaxGrade());
        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologists);
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }


    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@RequestBody SearchDto dto) {
        List<Dermatologist> dermatologists = dermatologistService.search(dto.getName(), dto.getSurname());
        List<SearchDermatologistDto> dermatologistDtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologists);
        return new ResponseEntity<>(dermatologistDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllByAdmin(@AuthenticationPrincipal PharmacyAdministrator pharmacyAdmin) {
        Long pharmacyId = pharmacyAdmin.getPharmacyId();
        List<Dermatologist> dermatologists = dermatologistService.findAllByPharmacyId(pharmacyId);
        List<SearchDermatologistDto> dtos = DermatologistMapper.mapDermatologistsToDermatologistDtos(dermatologists);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
