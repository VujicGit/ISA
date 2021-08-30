package com.isa.supplier.controller;

import com.isa.helper.http.Message;
import com.isa.supplier.domain.Offer;
import com.isa.supplier.dto.CreateOfferDto;
import com.isa.supplier.dto.OfferDto;
import com.isa.supplier.mapper.OfferMapper;
import com.isa.supplier.service.interfaces.IOfferService;
import com.isa.user.domain.PharmacyAdministrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private final IOfferService offerService;

    @Autowired
    public OfferController(IOfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping(value = "/orderId/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllByOrderId(@PathVariable Long orderId) {
        List<Offer> offers = offerService.findAllByOrderId(orderId);
        List<OfferDto> dtos = OfferMapper.mapOffersToOfferDtos(offers);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOffer(@RequestBody CreateOfferDto dto) {
        Offer offer = OfferMapper.mapCreateOfferDtoToOffer(dto);
        return new ResponseEntity<>(offerService.createOffer(dto).getId(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/accept/{offerId}/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptOffer(@PathVariable Long offerId, @PathVariable Long orderId) {

        PharmacyAdministrator pharmacyAdministrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long pharmacyAdminId = pharmacyAdministrator.getId();
        offerService.acceptOffer(pharmacyAdminId, offerId, orderId);
        return new ResponseEntity<>(new Message("Success"), HttpStatus.OK);
    }
}
