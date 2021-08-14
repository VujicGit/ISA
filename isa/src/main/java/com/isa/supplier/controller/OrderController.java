package com.isa.supplier.controller;

import com.isa.supplier.domain.Order;
import com.isa.supplier.dto.CreateOrderDto;
import com.isa.supplier.dto.OrderDto;
import com.isa.supplier.mapper.OrderMapper;
import com.isa.supplier.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final IOrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(IOrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderDto dto) {

        Long pharmacyId = 1L; //get pharmacy id from jwt
        Long pharmacyAdministrator = 1L; //get pharmacy administrator from jwt
        Order order = orderService.save(dto, pharmacyId, pharmacyAdministrator);
        return new ResponseEntity<>(order.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllByPharmacyId(@PathVariable Long pharmacyId) {

        List<Order> orders = orderService.findAllByPharmacyId(1L);
        List<OrderDto> dtos = orderMapper.mapOrdersToOrderDtos(orders);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }



}
