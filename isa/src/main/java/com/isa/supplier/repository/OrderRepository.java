package com.isa.supplier.repository;

import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.enumeration.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "select distinct o from Order o " +
            "left join fetch o.pharmacy left join fetch o.pharmacyAdministrator join fetch o.orderedDrug oD join fetch oD.drug" +
            " where o.pharmacy.id = ?1" )
    List<Order> findAllByPharmacyId(Long pharmacyId);

    @Query(value = "select distinct o from Order o " +
            "left join fetch o.pharmacy left join fetch o.pharmacyAdministrator join fetch o.orderedDrug oD join fetch oD.drug " +
            "where o.pharmacy.id = ?1 and o.status = ?2")
    List<Order> filterByStatus(Long pharmacyId, OrderStatus status);

}
