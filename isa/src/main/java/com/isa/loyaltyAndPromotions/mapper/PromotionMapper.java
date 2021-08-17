package com.isa.loyaltyAndPromotions.mapper;

import com.isa.loyaltyAndPromotions.domain.Promotion;
import com.isa.loyaltyAndPromotions.dto.PromotionDto;

import java.util.List;
import java.util.stream.Collectors;

public class PromotionMapper {

    public static List<PromotionDto> mapPromotionsToPromotionDtos(List<Promotion> promotions) {
        return promotions.stream().map(PromotionDto::new).collect(Collectors.toList());
    }
}
