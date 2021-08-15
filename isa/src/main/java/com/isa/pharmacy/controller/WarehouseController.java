package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.pharmacy.dto.ItemDto;
import com.isa.pharmacy.mapper.ItemMapper;
import com.isa.pharmacy.service.implementation.WarehouseService;
import com.isa.pharmacy.service.interfaces.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final IWarehouseService warehouseService;

    @Autowired
    public WarehouseController(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findItemsByPharmacyId() {

        Long pharmacyId = 1L; //get from jwt
        List<Item> items = warehouseService.findByPharmacyId(pharmacyId).getItems();
        if (items == null) {
            items = new ArrayList<>();
        }
        List<ItemDto> itemDtos = ItemMapper.mapItemsToItemsDtos(items);
        return new ResponseEntity<>(itemDtos, HttpStatus.OK);

    }
}
