package com.isa.user.service.implementation;


import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Dermatologist;

import com.isa.user.dto.ShiftDto;
import com.isa.user.repository.DermatologistRepository;
import com.isa.user.service.interfaces.IDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DermatologistService implements IDermatologistService {

   private final DermatologistRepository dermatologistRepository;

   @Autowired
   public DermatologistService(DermatologistRepository dermatologistRepository) {
       this.dermatologistRepository = dermatologistRepository;
   }


    @Override
    public List<Dermatologist> findAll() {
       return dermatologistRepository.findAll();
    }


    @Override
    public List<Dermatologist> findAllWithPharmacies() {
        return dermatologistRepository.findAllWithPharmacies();
    }

    @Override
    public List<Dermatologist> filter(String name, String surname, Long id, double minGrade, double maxGrade) {
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
        return dermatologistRepository.filterByPharmaciesAndGrade(name, surname, id, minGrade, maxGrade);
    }

    @Override
    public List<Dermatologist> search(String name, String surname) {
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
        return dermatologistRepository.search(name, surname);
    }


}
