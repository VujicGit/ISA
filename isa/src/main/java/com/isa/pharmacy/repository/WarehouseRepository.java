package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(value = "select w from Warehouse w join fetch w.pharmacy p join fetch w.items i join fetch i.drug d join fetch d.ingredients " +
            "where p.id = ?1")
    Warehouse findByPharmacyId(Long pharmacyId);

    @Query(value = "select w from Warehouse w left join fetch w.pharmacy p left join fetch w.items i left join fetch i.drug " +
            "where p.id = ?1")
    Optional<Warehouse> findByPharmacyIdWithDrugs(Long pharmacyId);

}
