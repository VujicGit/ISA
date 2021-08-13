package com.isa.user.service.implementation;

import com.isa.user.domain.Pharmacist;
import com.isa.user.repository.PharmacistRepository;
import com.isa.user.service.interfaces.IPharmacistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService implements IPharmacistService {

    private final PharmacistRepository pharmacistRepository;

    public PharmacistService(PharmacistRepository pharmacistRepository) {
        this.pharmacistRepository = pharmacistRepository;
    }

    @Override
    public List<Pharmacist> findAllWithPharmacies() {
        return this.pharmacistRepository.findAllWithPharmacies();
    }

    @Override
    public List<Pharmacist> search(String name, String surname) {
        name = name.toLowerCase();
        surname = surname.toLowerCase();
        name = name.trim();
        surname = surname.trim();
        if(name.equals("")) {
            name = "%";
        }
        if(surname.equals("")) {
            surname = "%";
        }

        return pharmacistRepository.search(name, surname);

    }

    @Override
    public List<Pharmacist> filter(String name, String surname, Long pharmacyId, double minGrade, double maxGrade) {
        name = name.toLowerCase();
        surname = surname.toLowerCase();
        name = name.trim();
        surname = surname.trim();
        if (name.equals("")) {
            name = "%";
        }
        if (surname.equals("")) {
            surname = "%";
        }

        return pharmacistRepository.filter(name, surname, pharmacyId, minGrade, maxGrade);
    }


}
