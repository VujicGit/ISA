package com.isa.user.service.implementation;

import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.repository.PharmacyAdminRepository;
import com.isa.user.service.interfaces.IPharmacyAdminService;
import org.springframework.stereotype.Service;

@Service
public class PharmacyAdminService implements IPharmacyAdminService {

    private final PharmacyAdminRepository pharmacyAdminRepository;

    public PharmacyAdminService(PharmacyAdminRepository pharmacyAdminRepository) {
        this.pharmacyAdminRepository = pharmacyAdminRepository;
    }

    @Override
    public PharmacyAdministrator findById(Long id) {
        return pharmacyAdminRepository.findById(id).orElse(new PharmacyAdministrator());
    }
}
