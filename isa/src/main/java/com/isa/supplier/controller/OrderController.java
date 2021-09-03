package com.isa.supplier.controller;

import com.isa.helper.error.ErrorMapper;
import com.isa.helper.http.Message;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.dto.CreateOrderDto;
import com.isa.supplier.dto.OrderDto;
import com.isa.supplier.mapper.OrderMapper;
import com.isa.supplier.service.interfaces.IOrderService;
import com.isa.user.domain.PharmacyAdministrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

        PharmacyAdministrator pharmacyAdministrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long pharmacyId = pharmacyAdministrator.getPharmacyId(); //get pharmacy id from jwt
        Long pharmacyAdministratorId = pharmacyAdministrator.getId(); //get pharmacy administrator from jwt
        Order order = orderService.save(dto, pharmacyId, pharmacyAdministratorId);
        return new ResponseEntity<>(new Message("Success"), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllByPharmacyId() {

        PharmacyAdministrator pharmacyAdministrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long pharmacyId = pharmacyAdministrator.getPharmacyId();
        List<Order> orders = orderService.findAllByPharmacyId(pharmacyId);
        List<OrderDto> dtos = OrderMapper.mapOrdersToOrderDtos(orders);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @GetMapping(value = "/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterByStatus(@PathVariable OrderStatus status) {

        PharmacyAdministrator pharmacyAdministrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long pharmacyId = pharmacyAdministrator.getPharmacyId();
        List<Order> orders = orderService.filterByStatus(pharmacyId, status);
        List<OrderDto> dtos = OrderMapper.mapOrdersToOrderDtos(orders);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
