package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Warehouse;

import java.util.List;

public interface IWarehouseService {

    Warehouse findByPharmacyId(Long pharmacyId);
    Warehouse save(Warehouse warehouse);
    Warehouse deleteItem(Long pharmacyId, String drugCode);
    List<Item> search(Long pharmacyId, String drugCode);
    void updateQuantity(Long pharmacyId, Long drugId, int quantity);

}
