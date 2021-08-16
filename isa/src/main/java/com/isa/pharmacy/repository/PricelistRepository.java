package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

    @Query("select distinct p from Pricelist p left join fetch p.pharmacy ph left join fetch p.prices pr left join fetch pr.drug " +
            "where ph.id = ?1")
    Pricelist getPricelistByPharmacyId(Long pharmacyId);

}
