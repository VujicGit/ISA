package com.isa.loyaltyAndPromotions.repository;

import com.isa.loyaltyAndPromotions.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(value = "select distinct s from Subscription s left join fetch s.pharmacy ph left join fetch s.patient p " +
            "where ph.id = ?1")
    Subscription getSubscriptionByPharmacyIdWithPatients(Long pharmacyId);
    Subscription getSubscriptionByPharmacyId(Long pharmacyId);

}
