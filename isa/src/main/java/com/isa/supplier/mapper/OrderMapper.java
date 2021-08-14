package com.isa.supplier.mapper;

import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.OrderedDrug;
import com.isa.supplier.dto.OrderDto;
import com.isa.supplier.dto.CreateOrderedDrugDto;
import com.isa.supplier.dto.OrderedDrugDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public List<OrderDto> mapOrdersToOrderDtos(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order it : orders) {
            List<OrderedDrug> orderedDrugs = it.getOrderedDrug();
            List<OrderedDrugDto> orderedDrugDtos = new ArrayList<>();
            for(OrderedDrug it2 : orderedDrugs) {
                OrderedDrugDto orderedDrugDto = new OrderedDrugDto(it2.getDrug().getName(), it2.getDrug().getCode(), it2.getQuantity());
                orderedDrugDtos.add(orderedDrugDto);
            }
            String createdBy = "Nema admina";
            if(it.getPharmacyAdministrator() != null) {
                createdBy = it.getPharmacyAdministrator().getName() + it.getPharmacyAdministrator().getSurname();
            }
            OrderDto dto = new OrderDto(orderedDrugDtos, createdBy, it.getCreationDate(), it.getDueDate(), it.getStatus().toString());
            orderDtos.add(dto);

        }

        return orderDtos;
    }

}
