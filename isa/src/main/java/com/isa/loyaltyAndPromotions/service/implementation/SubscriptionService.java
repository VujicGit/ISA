package com.isa.loyaltyAndPromotions.service.implementation;

import com.isa.loyaltyAndPromotions.domain.Subscription;
import com.isa.loyaltyAndPromotions.repository.SubscriptionRepository;
import com.isa.loyaltyAndPromotions.service.interfaces.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService implements ISubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription getSubscriptionByPharmacyIdWithPatients(Long pharmacyId) {
        return subscriptionRepository.getSubscriptionByPharmacyIdWithPatients(pharmacyId);
    }

    @Override
    public Subscription getSubscriptionByPharmacyId(Long pharmacyId) {
        return subscriptionRepository.getSubscriptionByPharmacyId(pharmacyId);
    }
}
