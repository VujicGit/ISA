package com.isa.loyaltyAndPromotions.service.interfaces;

import com.isa.loyaltyAndPromotions.domain.Subscription;

public interface ISubscriptionService {

    Subscription getSubscriptionByPharmacyIdWithPatients(Long pharmacyId);
    Subscription getSubscriptionByPharmacyId(Long pharmacyId);
}
