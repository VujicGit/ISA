package com.isa.appointment.repository;

import com.isa.appointment.domain.Examination;
import com.isa.user.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    List<Examination> findAllByDermatologistId(Long dermatologistId);

    @Query(value = "select case when count(e) > 0 then true else false end from Examination e " +
            "left join e.pharmacy p left join e.dermatologist d " +
            "where p.id = ?2 and d.id = ?1 ")
    boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId);

    @Query("select case when count(e) > 0 then true else false end from Examination e " +
            "where e.dermatologistId = :#{#examination.dermatologist.id} and " +
            "e.pharmacyId = :#{#examination.pharmacy.id} and " +
            "e.appointmentDuration.start = :#{#examination.appointmentDuration.start} and " +
            "e.appointmentDuration.end = :#{#examination.appointmentDuration.end}")
    boolean exists(@Param("examination") Examination examination);

}
