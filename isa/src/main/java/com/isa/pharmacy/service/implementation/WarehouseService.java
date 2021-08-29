package com.isa.pharmacy.service.implementation;

import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.pharmacy.repository.WarehouseRepository;
import com.isa.pharmacy.service.interfaces.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarehouseService implements IWarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse findByPharmacyId(Long pharmacyId) {
        Warehouse warehouse = warehouseRepository.findByPharmacyId(pharmacyId);
        return Optional.ofNullable(warehouse).orElse(new Warehouse());
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse deleteItem(Long pharmacyId, String drugCode) {

        Warehouse warehouse = warehouseRepository.findByPharmacyId(pharmacyId);

        List<Item> items = warehouse.getItems();
        Item itemToDelete = items.stream().filter(item -> item.getDrug().getCode().equals(drugCode)).findFirst().orElse(null);
        items.remove(itemToDelete);
        if(itemToDelete == null) return null;

        warehouse.setItems(items);

        return warehouseRepository.save(warehouse);
    }

    @Override
    public List<Item> search(Long pharmacyId, String drugCode) {
        Warehouse warehouse = warehouseRepository.findByPharmacyId(pharmacyId);
        return warehouse.getItems().stream().filter(item -> item.getDrug().getCode().equals(drugCode)).collect(Collectors.toList());
    }
}
