package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
