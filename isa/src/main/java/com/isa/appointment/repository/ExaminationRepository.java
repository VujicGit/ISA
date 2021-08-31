package com.isa.appointment.repository;

import com.isa.appointment.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    @Query(value = "select case when count(e) > 0 then true else false end from Examination e " +
            "left join e.pharmacy p left join e.dermatologist d " +
            "where p.id = ?2 and d.id = ?1 ")
    boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId);
}
