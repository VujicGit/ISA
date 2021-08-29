package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Pricelist;
import com.isa.pharmacy.dto.AddPriceDto;
import com.isa.pharmacy.dto.PriceDto;
import com.isa.pharmacy.mapper.PricelistMapper;
import com.isa.pharmacy.service.interfaces.IPricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pricelist")
public class PricelistController {

    private final IPricelistService pricelistService;

    @Autowired
    public PricelistController(IPricelistService pricelistService) {
        this.pricelistService = pricelistService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {

        Long pharmacyId = 1L; //get from jwt
        List<PriceDto> dtos = PricelistMapper.mapPricesToPricesDto(pricelistService.getPricesByPharmacyId(pharmacyId));
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPrice(@RequestBody AddPriceDto priceDto) {
        Long pharmacyId = 1L;

        Pricelist pricelist = pricelistService.addPrice(pharmacyId, priceDto);
        if(pricelist == null)
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePrice() {
        return null;
    }
}
