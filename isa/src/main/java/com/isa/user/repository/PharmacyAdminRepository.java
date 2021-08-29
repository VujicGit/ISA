package com.isa.user.repository;

import com.isa.user.domain.PharmacyAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdministrator, Long> {

}
