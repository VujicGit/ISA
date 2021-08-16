package com.isa.drug.service.implementation;

import com.isa.drug.domain.Drug;
import com.isa.drug.repository.DrugRepository;
import com.isa.drug.service.interfaces.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DrugService implements IDrugService {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> findAll() {
        return drugRepository.findAllWithIngredients();
    }

    @Override
    public Drug findById(Long id) {
        return drugRepository.findById(id).get();
    }
}
