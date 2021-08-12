package com.isa.user.service.interfaces;

import com.isa.user.domain.Pharmacist;
import java.util.List;

public interface IPharmacistService {

    List<Pharmacist> findAllWithPharmacies();
    List<Pharmacist> search(String name, String surname);
    List<Pharmacist> filter(String name, String surname, Long pharmacyId, double minGrade, double maxGrade);

}
