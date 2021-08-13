package com.isa.drug.repository;

import com.isa.drug.domain.Drug;
import com.isa.user.domain.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface DrugRepository extends JpaRepository<Drug, Long> {

}
