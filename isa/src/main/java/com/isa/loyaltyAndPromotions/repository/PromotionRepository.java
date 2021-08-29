package com.isa.loyaltyAndPromotions.repository;

import com.isa.loyaltyAndPromotions.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {


    List<Promotion> findAllByPharmacyId(Long pharmacyId);

}
