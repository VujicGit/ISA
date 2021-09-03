package com.isa.user.repository;

import com.isa.user.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

    List<Shift> getAllByEmployeeId(Long id);
    List<Shift> getAllByEmployeeIdAndPharmacyId(Long employeeId, Long pharmacyId);

    @Query("select case when count(s) > 0 then true else false end from Shift s " +
            "where s.employeeId = :#{#shift.employee.id} and " +
            "s.pharmacyId = :#{#shift.pharmacy.id} and " +
            "s.duration.start = :#{#shift.duration.start} and " +
            "s.duration.end = :#{#shift.duration.end}")
    boolean exists(@Param("shift") Shift shift);

}
