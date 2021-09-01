package com.isa.user.service.interfaces;

import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.enumeration.VacationRequestStatus;

import java.util.List;

public interface IDermatologistVacationRequestService {

    DermatologistVacationRequest process(Long id, VacationRequestStatus status, String message);
    List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyIdAndStatus(Long pharmacyId, VacationRequestStatus status);
    List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyId(Long pharmacyId);
    DermatologistVacationRequest getDermatologistVacationRequestById(Long id);
    List<DermatologistVacationRequest> filter(Long pharmacyId, String name, String surname, VacationRequestStatus status);
}
