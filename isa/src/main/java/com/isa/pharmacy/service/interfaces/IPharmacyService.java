package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;

import java.util.List;

public interface IPharmacyService {

    Pharmacy getById(Long pharmacyId);
    Pharmacy findById(Long pharmacyId);
    List<Pharmacy> findAll();
    Pharmacy update(PharmacyDto pharmacyDto);
}
