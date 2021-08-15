package com.isa.loyaltyAndPromotions.controller;

import com.isa.helper.ErrorMapper;
import com.isa.loyaltyAndPromotions.domain.Point;
import com.isa.loyaltyAndPromotions.dto.PointDto;
import com.isa.loyaltyAndPromotions.service.implementation.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/points")
public class PointController {



    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;

    }


    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@Valid @RequestBody PointDto dto, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<>(ErrorMapper.Map(result.getAllErrors()), HttpStatus.BAD_REQUEST);
        }


        Point point = new Point(dto.getExaminationPoints(), dto.getConsultationPoints());

        point = pointService.save(point);

        return new ResponseEntity<>(point, HttpStatus.OK);

    }
}
