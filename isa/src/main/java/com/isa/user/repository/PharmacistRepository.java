package com.isa.user.repository;

import com.isa.user.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

    @Query(value = "select p from Pharmacist p join fetch p.pharmacy")
    List<Pharmacist> findAllWithPharmacies();

    @Query(value = "select p from Pharmacist p join fetch p.pharmacy ph " +
            "where lower(p.name) like ?1 and lower(p.surname) like ?2")
    List<Pharmacist> search(String name, String surname);

    @Query(value = "select p from Pharmacist p join fetch p.pharmacy ph " +
            "where lower(p.name) like ?1 and lower(p.surname) like ?2 and ph.id = ?3 and p.grade >= ?4 and p.grade <= ?5")
    List<Pharmacist> filter(String name, String surname, Long pharmacyId, double minGrade, double maxGrade);

}
