package com.isa.loyaltyAndPromotions.controller;

import com.isa.helper.Error;
import com.isa.loyaltyAndPromotions.domain.Promotion;
import com.isa.loyaltyAndPromotions.dto.PromotionDto;
import com.isa.loyaltyAndPromotions.mapper.PromotionMapper;
import com.isa.loyaltyAndPromotions.service.interfaces.IPromotionService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {

    private final IPromotionService promotionService;

    @Autowired
    public PromotionController(IPromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {


        Long pharmacyId = 1L; //get from jwt
        List<Promotion> promotions = promotionService.findAllByPharmacyId(pharmacyId);
        List<PromotionDto> promotionDtos = PromotionMapper.mapPromotionsToPromotionDtos(promotions);
        return new ResponseEntity<>(promotionDtos, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody PromotionDto promotionDto) {

        Long pharmacyId = 1L; //get from jwt
        Promotion promotion = promotionService.create(pharmacyId, promotionDto);
        if(promotion == null) {
            return new ResponseEntity<>(new Error("Can not create promotion"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(promotion.getId(), HttpStatus.OK);
    }
}
