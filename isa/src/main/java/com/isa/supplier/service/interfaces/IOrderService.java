package com.isa.supplier.service.interfaces;

import com.isa.supplier.domain.Order;
import com.isa.supplier.dto.CreateOrderDto;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();
    Order save(CreateOrderDto createOrderDto, Long pharmacyId, Long pharmacyAdmin);
    List<Order> findAllByPharmacyId(Long pharmacyId);
}
