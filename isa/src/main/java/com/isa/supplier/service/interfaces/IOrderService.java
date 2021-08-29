package com.isa.supplier.service.interfaces;

import com.isa.drug.domain.Drug;
import com.isa.pharmacy.domain.Item;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.OrderedDrug;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.dto.CreateOrderDto;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();
    Order save(CreateOrderDto createOrderDto, Long pharmacyId, Long pharmacyAdmin);
    List<Order> findAllByPharmacyId(Long pharmacyId);
    void addDrugToWarehouse(Long pharmacyId, List<OrderedDrug> orderedDrugs);
    List<Order> filterByStatus(Long pharmacyId, OrderStatus orderStatus);
}
