package com.isa.security.auth;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.domain.User;
import com.isa.user.domain.enumeration.Role;
import com.isa.user.repository.PharmacyAdminRepository;
import org.springframework.stereotype.Component;

@Component
public class PharmacyAdminAuthentication {

    private final PharmacyAdminRepository pharmacyAdminRepository;

    public PharmacyAdminAuthentication(PharmacyAdminRepository pharmacyAdminRepository) {
        this.pharmacyAdminRepository = pharmacyAdminRepository;
    }

    public PharmacyAdministrator authenticate(User user) {
        if(!isPharmacyAdministrator(user)) {
            return null;
        }

        return pharmacyAdminRepository.getById(user.getId());

    }

    private boolean isPharmacyAdministrator(User user) {
        return user.getRole() == Role.PHARMACY_ADMINISTRATOR;
    }
}
