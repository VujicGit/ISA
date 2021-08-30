package com.isa.user.service.implementation;

import com.isa.user.domain.Supplier;
import com.isa.user.repository.SupplierRepository;
import com.isa.user.service.interfaces.ISupplierService;
import org.springframework.stereotype.Component;

@Component
public class SupplierService implements ISupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }
}
