package com.isa.supplier.controller;

import com.isa.helper.error.ErrorMapper;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.dto.CreateOrderDto;
import com.isa.supplier.dto.OrderDto;
import com.isa.supplier.mapper.OrderMapper;
import com.isa.supplier.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderDto dto,  BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<>(ErrorMapper.Map(result.getAllErrors()), HttpStatus.BAD_REQUEST);
        }

        Long pharmacyId = 1L; //get pharmacy id from jwt
        Long pharmacyAdministrator = 3L; //get pharmacy administrator from jwt
        Order order = orderService.save(dto, pharmacyId, pharmacyAdministrator);
        return new ResponseEntity<>(order.getId(), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllByPharmacyId() {

        Long pharmacyId = 1L; //get from jwt
        List<Order> orders = orderService.findAllByPharmacyId(pharmacyId);
        List<OrderDto> dtos = OrderMapper.mapOrdersToOrderDtos(orders);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterByStatus(@PathVariable Integer status) {

        OrderStatus orderStatus = OrderStatus.intConverter(status);
        Long pharmacyId = 1L; //get from jwt
        List<Order> orders = orderService.filterByStatus(pharmacyId, orderStatus);
        List<OrderDto> dtos = OrderMapper.mapOrdersToOrderDtos(orders);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
