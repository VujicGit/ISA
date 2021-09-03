package com.isa.user.service.interfaces;

import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.ShiftDto;


import java.util.List;

public interface IDermatologistService {

    List<Dermatologist> findAll();
    List<Dermatologist> findAllWithPharmacies();
    List<Dermatologist> filter(String name, String surname, Long id, double minGrade, double maxGrade);
    List<Dermatologist> search(String name, String surname);
    List<Dermatologist> findAllByPharmacyId(Long pharmacyId);

}
