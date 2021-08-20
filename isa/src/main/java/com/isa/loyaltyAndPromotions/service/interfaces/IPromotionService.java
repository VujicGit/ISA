package com.isa.loyaltyAndPromotions.service.interfaces;

import com.isa.loyaltyAndPromotions.domain.Promotion;
import com.isa.loyaltyAndPromotions.dto.PromotionDto;

import java.util.List;

public interface IPromotionService {

    Promotion create(Long pharmacyId, PromotionDto promotion);
    List<Promotion> findAllByPharmacyId(Long pharmacyId);
}
