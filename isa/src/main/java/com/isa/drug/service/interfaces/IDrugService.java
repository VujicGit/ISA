package com.isa.drug.service.interfaces;

import com.isa.drug.domain.Drug;

import java.util.List;
import java.util.Set;

public interface IDrugService {

    List<Drug> findAll();
    Drug findById(Long id);
}
