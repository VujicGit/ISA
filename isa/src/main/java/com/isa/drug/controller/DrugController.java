package com.isa.drug.controller;

import com.isa.drug.domain.Drug;
import com.isa.drug.dto.BasicDrugDto;
import com.isa.drug.dto.DrugIdDto;
import com.isa.drug.mapper.DrugMapper;
import com.isa.drug.service.interfaces.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/drug")
public class DrugController {

    private final IDrugService drugService;
    private final DrugMapper drugMapper;

    @Autowired
    public DrugController(IDrugService drugService, DrugMapper drugMapper) {
        this.drugMapper = drugMapper;
        this.drugService = drugService;
    }


    @GetMapping
    public ResponseEntity<?> findAll() {
        //List<DrugIdDto> drugIdDtos = drugMapper.mapDrugsToDrugIdDtos(drugService.findAll());
        List<Drug> drugs = drugService.findAll();
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping(value = "/basic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllBasic() {
        List<Drug> drugs = drugService.findAll();
        List<BasicDrugDto> dtos = DrugMapper.mapDrugsToBasicDrugDtos(drugs);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
