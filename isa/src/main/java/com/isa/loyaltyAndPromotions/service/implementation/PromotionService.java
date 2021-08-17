package com.isa.loyaltyAndPromotions.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.loyaltyAndPromotions.domain.Promotion;
import com.isa.loyaltyAndPromotions.dto.PromotionDto;
import com.isa.loyaltyAndPromotions.repository.PromotionRepository;
import com.isa.loyaltyAndPromotions.service.interfaces.IPromotionService;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    private final PromotionRepository promotionRepository;
    private final IPharmacyService pharmacyService;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository, IPharmacyService pharmacyService) {
        this.promotionRepository = promotionRepository;
        this.pharmacyService = pharmacyService;
    }
    @Override
    public Promotion create(Long pharmacyId, PromotionDto promotion) {
        Pharmacy pharmacy = pharmacyService.getById(pharmacyId);
        if(pharmacy == null) return null;

        TimePeriod timePeriod = new TimePeriod(promotion.getStart(), promotion.getEnd());
        Promotion newPromotion = new Promotion(promotion.getDescription(), timePeriod, pharmacy);

        return promotionRepository.save(newPromotion);
    }

    @Override
    public List<Promotion> findAllByPharmacyId(Long pharmacyId) {
        return promotionRepository.findAllByPharmacyId(pharmacyId);
    }
}
