package com.isa.pharmacy.service.implementation;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService implements IPharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Pharmacy getById(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElse(new Pharmacy());
    }

    @Override
    public Pharmacy findById(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElse(null);
    }

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }


}
