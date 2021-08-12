package com.isa.user.service.implementation;


import com.isa.user.domain.Dermatologist;

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
}
