package com.isa.supplier.repository;

import com.isa.supplier.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "select o from Order o " +
            "left join fetch o.pharmacy " +
            "where o.pharmacy.id = ?1" )
    List<Order> findAllByPharmacyId(Long pharmacyId);


}
