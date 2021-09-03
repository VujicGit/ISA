package com.isa.appointment.service.implementation;

import com.isa.appointment.domain.Examination;
import com.isa.appointment.domain.TimePeriod;
import com.isa.appointment.domain.enums.AppointmentStatus;
import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.appointment.dto.ExaminationDto;
import com.isa.appointment.exception.ExaminationException;
import com.isa.appointment.repository.ExaminationRepository;
import com.isa.appointment.service.interfaces.IExaminationService;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.Shift;
import com.isa.user.domain.enumeration.VacationRequestStatus;
import com.isa.user.repository.DermatologistRepository;
import com.isa.user.repository.DermatologistVacationRequestRepository;
import com.isa.user.service.interfaces.IShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExaminationService implements IExaminationService {

    private final ExaminationRepository examinationRepository;
    private final DermatologistRepository dermatologistRepository;
    private final PharmacyRepository pharmacyRepository;
    private final DermatologistVacationRequestRepository dermatologistVacationRequestRepository;
    private final IShiftService shiftService;

    @Autowired
    public ExaminationService(ExaminationRepository examinationRepository, DermatologistRepository dermatologistRepository, PharmacyRepository pharmacyRepository, IShiftService shiftService, DermatologistVacationRequestRepository dermatologistVacationRequestRepository) {
        this.examinationRepository = examinationRepository;
        this.dermatologistRepository = dermatologistRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.shiftService = shiftService;
        this.dermatologistVacationRequestRepository = dermatologistVacationRequestRepository;
    }

    @Override
    public Examination schedule(ExaminationDto examinationDto) {
        return null;
    }


    @Override
    public boolean existsByDermatologistIdAndPharmacyId(Long dermatologistId, Long pharmacyId) {
        return examinationRepository.existsByDermatologistIdAndPharmacyId(dermatologistId, pharmacyId);
    }

    @Override
    public Examination define(Long pharmacyId, ExaminationDto examinationDto) {
        return createExamination(pharmacyId, examinationDto);
    }

    private Examination createExamination(Long pharmacyId, ExaminationDto examinationDto) {
        Dermatologist dermatologist = dermatologistRepository.findByIdAndPharmacyId(pharmacyId, examinationDto.getDermatologistId()).orElseThrow();
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow();
        Examination examination = new Examination();
        examination.setDermatologist(dermatologist);
        examination.setPharmacy(pharmacy);
        examination.setCost(examinationDto.getPrice());
        examination.setType(AppointmentType.EXAMINATION);
        examination.setStatus(AppointmentStatus.CREATED);
        TimePeriod duration = new TimePeriod(examinationDto.getStart(), examinationDto.getEnd());
        if(!isInWorkingHours(dermatologist.getId(), pharmacyId, duration))
            throw new ExaminationException("Examination is not in dermatologist working hours");
        examination.setAppointmentDuration(duration);
        if(examinationRepository.exists(examination))
            throw new ExaminationException("Examination is already scheduled");
        if(isOverlapping(dermatologist.getId(), examination))
            throw new ExaminationException("Examination is overlapping");
        if(isOnVacation(examination))
            throw new ExaminationException("Dermatologist is on vacation");

        return examinationRepository.save(examination);
    }

    private boolean isOverlapping(Long dermatologistId, Examination examination) {
        List<Examination> examinations = examinationRepository.findAllByDermatologistId(dermatologistId);
        if(examinations.size() == 0) return false;

        for(Examination it : examinations) {
            boolean isBefore = isExaminationBefore(examination, it);
            boolean isAfter = isExaminationAfter(examination, it);

            if(!isAfter && !isBefore) {
                return true;
            }
        }
        return false;

    }

    private boolean isExaminationAfter(Examination examination, Examination it) {
        return examination.getAppointmentDuration().getStart().isAfter(it.getAppointmentDuration().getEnd())
                && examination.getAppointmentDuration().getEnd().isAfter(it.getAppointmentDuration().getEnd());
    }

    private boolean isExaminationBefore(Examination examination, Examination it) {
        return examination.getAppointmentDuration().getStart().isBefore(it.getAppointmentDuration().getStart())
                && examination.getAppointmentDuration().getEnd().isBefore(it.getAppointmentDuration().getStart());
    }

    private boolean isExaminationAfter(Examination examination, DermatologistVacationRequest it) {
        return examination.getAppointmentDuration().getStart().isAfter(it.getVacationTime().getEnd())
                && examination.getAppointmentDuration().getEnd().isAfter(it.getVacationTime().getEnd());
    }

    private boolean isExaminationBefore(Examination examination, DermatologistVacationRequest it) {
        return examination.getAppointmentDuration().getStart().isBefore(it.getVacationTime().getStart())
                && examination.getAppointmentDuration().getEnd().isBefore(it.getVacationTime().getStart());
    }



    private boolean isInWorkingHours(Long dermatologistId, Long pharmacyId, TimePeriod duration) {

        List<Shift> shifts = shiftService.getAllByEmployeeIdAndPharmacyId(dermatologistId, pharmacyId);

        for(Shift it : shifts) {
            boolean isInWorkingHours = it.getDuration().getStart().isBefore(duration.getStart())
                    && it.getDuration().getEnd().isAfter(duration.getEnd());

            if(isInWorkingHours) return true;
        }

        return false;
    }

    private boolean isOnVacation(Examination examination) {
        List<DermatologistVacationRequest> vacationRequests = dermatologistVacationRequestRepository
                .getFuture(LocalDateTime.now(), examination.getPharmacy().getId(), examination.getDermatologist().getId(), VacationRequestStatus.ACCEPTED);

        return false;
    }
}
