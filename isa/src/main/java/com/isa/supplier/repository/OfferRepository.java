package com.isa.supplier.repository;

import com.isa.supplier.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByOrderId(Long orderId);

    @Query(value = "select distinct o from Offer o " +
            "left join fetch o.supplier " +
            "where o.orderId = ?1")
    Optional<List<Offer>> findAllByOrderIdWithSupplier(Long orderId);

}
