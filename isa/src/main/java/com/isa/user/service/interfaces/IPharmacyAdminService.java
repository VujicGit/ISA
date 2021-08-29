package com.isa.user.service.interfaces;

import com.isa.user.domain.PharmacyAdministrator;

public interface IPharmacyAdminService {

    PharmacyAdministrator findById(Long id);
}
