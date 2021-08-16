package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Warehouse;

public interface IWarehouseService {

    Warehouse findByPharmacyId(Long pharmacyId);
    Warehouse save(Warehouse warehouse);
}
