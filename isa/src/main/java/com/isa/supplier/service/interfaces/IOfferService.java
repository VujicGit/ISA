package com.isa.supplier.service.interfaces;

import com.isa.supplier.domain.Offer;
import com.isa.supplier.domain.Order;
import com.isa.supplier.dto.CreateOfferDto;

import java.util.List;

public interface IOfferService {

    List<Offer> findAllByOrderId(Long orderId);
    Offer createOffer(CreateOfferDto dto);
    void acceptOffer(Long pharmacyAdminId, Long offerId, Long orderId);
}
