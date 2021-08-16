package com.isa.pharmacy.service.implementation;

import com.isa.pharmacy.domain.Warehouse;
import com.isa.pharmacy.repository.WarehouseRepository;
import com.isa.pharmacy.service.interfaces.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Warehouse retVal = Optional.ofNullable(warehouse).orElse(new Warehouse());
        return retVal;
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }
}
