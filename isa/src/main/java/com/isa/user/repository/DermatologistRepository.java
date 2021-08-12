package com.isa.user.repository;

import com.isa.user.domain.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

    @Query(value = "select d from Dermatologist d join fetch d.address")
    List<Dermatologist> findAllWithAddress();

    @Query(value = "select d from Dermatologist d join fetch d.pharmacies")
    List<Dermatologist> findAllWithPharmacies();

    @Query(value = "select d from Dermatologist d join fetch d.pharmacies p where lower(d.name) like ?1 and lower(d.surname) like ?2")
    List<Dermatologist> search(String name, String surname);

    @Query(value = "select d from Dermatologist d join fetch d.pharmacies p " +
            "where lower(d.name) like ?1 and lower(d.surname) like ?2 and p.id = ?3 and d.grade > ?4 and d.grade <= ?5")
    List<Dermatologist> filterByPharmaciesAndGrade(String name, String surname, Long pharmacyId, double minGrade, double maxGrade);
}

