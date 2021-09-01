package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.pharmacy.dto.ItemDto;
import com.isa.pharmacy.mapper.ItemMapper;
import com.isa.pharmacy.service.implementation.WarehouseService;
import com.isa.pharmacy.service.interfaces.IWarehouseService;
import com.isa.user.domain.PharmacyAdministrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/warehouse")
public class WarehouseController {

    private final IWarehouseService warehouseService;

    @Autowired
    public WarehouseController(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findItemsByPharmacyId() {

        PharmacyAdministrator pharmacyAdministrator = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long pharmacyId = pharmacyAdministrator.getPharmacyId();
        List<Item> items = warehouseService.findByPharmacyId(pharmacyId).getItems();
        if (items == null) {
            items = new ArrayList<>();
        }
        List<ItemDto> itemDtos = ItemMapper.mapItemsToItemsDtos(items);
        return new ResponseEntity<>(itemDtos, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{drugId}")
    public ResponseEntity<?> delete(@PathVariable String drugId) {
        Long pharmacyId = 1L;
        Warehouse warehouse = warehouseService.deleteItem(pharmacyId, drugId);
        if(warehouse == null) {
            return new ResponseEntity<>(new Error("Error"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/search/{drugCode}")
    public ResponseEntity<?> search(@PathVariable String drugCode) {
        Long pharmacyId = 1L;
        List<Item> items = warehouseService.search(pharmacyId, drugCode);
        List<ItemDto> itemDtos = ItemMapper.mapItemsToItemsDtos(items);
        return new ResponseEntity<>(itemDtos, HttpStatus.OK);
    }

}
