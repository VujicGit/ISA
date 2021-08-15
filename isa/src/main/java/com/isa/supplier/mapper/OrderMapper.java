package com.isa.supplier.mapper;

import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.OrderedDrug;
import com.isa.supplier.dto.OrderDto;
import com.isa.supplier.dto.OrderedDrugDto;
import java.util.List;
import java.util.stream.Collectors;


public class OrderMapper {

    public static List<OrderDto> mapOrdersToOrderDtos(List<Order> orders) {
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }
    
}
