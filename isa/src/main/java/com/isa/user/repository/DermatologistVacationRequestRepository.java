package com.isa.user.repository;

import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.enumeration.VacationRequestStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DermatologistVacationRequestRepository extends JpaRepository<DermatologistVacationRequest, Long> {

    @Query("select v from DermatologistVacationRequest v left join fetch v.pharmacy ph left join fetch v.dermatologist d " +
            "where ph.id = ?1")
    List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyId(Long pharmacyId);

    @Query("select v from DermatologistVacationRequest v left join fetch v.pharmacy ph left join fetch v.dermatologist d " +
            "where ph.id = ?1 and v.status = ?2")
    List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyIdAndStatus(Long pharmacyId, VacationRequestStatus status);

    @Query("select v from DermatologistVacationRequest v left join fetch v.dermatologist " +
            "where v.id = ?1 and v.pharmacyId = ?2")
    Optional<DermatologistVacationRequest> getDermatologistVacationRequestWithDermatologist(Long id, Long pharmacyId);

    DermatologistVacationRequest getDermatologistVacationRequestById(Long id);

    @Query("select v from DermatologistVacationRequest v left join fetch v.pharmacy ph left join fetch v.dermatologist d " +
            "where ph.id = ?1 and lower(d.name) like(lower(?2)) and lower(d.surname) like(lower(?3))")
    List<DermatologistVacationRequest> search(Long pharmacyId, String name, String surname);

}
