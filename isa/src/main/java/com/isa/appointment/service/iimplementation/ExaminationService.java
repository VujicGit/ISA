package com.isa.appointment.service.iimplementation;

import com.isa.appointment.repository.ExaminationRepository;
import com.isa.appointment.service.interfaces.IExaminationService;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService implements IExaminationService {

    private final ExaminationRepository examinationRepository;

    public ExaminationService(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }
    @Override
    public boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId) {
        return examinationRepository.existsByDermatologistIdAndPharmacyId(dermatologistId, pharmacyId);
    }
}
