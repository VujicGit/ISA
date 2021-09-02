package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query(value = "select p from Pharmacy p " +
            "left join fetch p.dermatologists " +
            "where p.id = ?1")
    Optional<Pharmacy> findByIdWithDermatologists(Long id);

    @Query(value = "select p from Pharmacy p " +
            "left join fetch p.address a left join fetch a.city ci left join fetch ci.country c " +
            "where p.id = ?1")
    Optional<Pharmacy> findById(Long id);
}
