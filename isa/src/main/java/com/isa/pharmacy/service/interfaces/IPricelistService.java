package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Price;
import com.isa.pharmacy.domain.Pricelist;
import com.isa.pharmacy.dto.AddPriceDto;
import com.isa.pharmacy.dto.PriceDto;

import java.util.List;

public interface IPricelistService {

    List<Price> getPricesByPharmacyId(Long pharmacyId);
    Pricelist addPrice(Long pharmacyId, AddPriceDto addPriceDto);
}
