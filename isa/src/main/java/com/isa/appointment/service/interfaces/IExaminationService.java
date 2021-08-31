package com.isa.appointment.service.interfaces;

public interface IExaminationService {

    boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId);
}
