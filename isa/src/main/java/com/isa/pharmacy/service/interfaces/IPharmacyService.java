package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Pharmacy;

public interface IPharmacyService {

    Pharmacy getById(Long pharmacyId);
    Pharmacy findById(Long pharmacyId);
}
