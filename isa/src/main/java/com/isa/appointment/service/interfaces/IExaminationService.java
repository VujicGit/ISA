package com.isa.appointment.service.interfaces;

import com.isa.appointment.domain.Examination;
import com.isa.appointment.dto.ExaminationDto;

public interface IExaminationService {

    Examination schedule(ExaminationDto examinationDto);
    boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId);
    Examination define(Long pharmacyId, ExaminationDto examinationDto);
}
