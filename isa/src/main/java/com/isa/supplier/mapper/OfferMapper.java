package com.isa.supplier.mapper;

import com.isa.supplier.domain.Offer;
import com.isa.supplier.dto.CreateOfferDto;
import com.isa.supplier.dto.OfferDto;

import java.util.List;
import java.util.stream.Collectors;

public class OfferMapper {

    public static List<OfferDto> mapOffersToOfferDtos(List<Offer> offers) {
        return offers.stream().map(OfferDto::new).collect(Collectors.toList());
    }

    public static Offer mapCreateOfferDtoToOffer(CreateOfferDto dto) {
        Offer offer = new Offer();
        offer.setOrderId(dto.getOrderId());
        offer.setPrice(dto.getPrice());
        offer.setDueDate(dto.getDueDate());
        return offer;
    }
}
