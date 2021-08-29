package com.isa.pharmacy.mapper;

import com.isa.pharmacy.domain.Price;
import com.isa.pharmacy.dto.PriceDto;

import java.util.List;
import java.util.stream.Collectors;

public class PricelistMapper {

    public static List<PriceDto> mapPricesToPricesDto(List<Price> prices) {
        return prices.stream().map(PriceDto::new).collect(Collectors.toList());
    }
}
