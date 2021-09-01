package com.isa.user.service.implementation;

import com.isa.appointment.service.interfaces.IExaminationService;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.ShiftDto;
import com.isa.user.exception.AlreadyEmployedException;
import com.isa.user.exception.RemoveEmployeeException;
import com.isa.user.repository.DermatologistRepository;
import com.isa.user.service.interfaces.IEmploymentService;
import com.isa.user.service.interfaces.IShiftService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmploymentService implements IEmploymentService {

    private final DermatologistRepository dermatologistRepository;
    private final PharmacyRepository pharmacyRepository;
    private final IShiftService shiftService;
    private final IExaminationService examinationService;

    @Autowired
    public EmploymentService(DermatologistRepository dermatologistRepository, PharmacyRepository pharmacyRepository, IShiftService shiftService, IExaminationService examinationService) {
        this.dermatologistRepository = dermatologistRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.shiftService = shiftService;
        this.examinationService = examinationService;
    }
    @Override
    public Dermatologist employDermatologist(Long dermatologistId, Long pharmacyId, ShiftDto shiftDto) {
        Dermatologist newDermatologist = setDermatologistToPharmacy(dermatologistId, pharmacyId);
        shiftService.createForDermatologist(newDermatologist, shiftDto);

        return newDermatologist;
    }


    @Override
    public Dermatologist employDermatologist(Long dermatologistId, Long pharmacyId, List<ShiftDto> shiftDtos) {
        Dermatologist newDermatologist = setDermatologistToPharmacy(dermatologistId, pharmacyId);
        shiftService.createForDermatologist(newDermatologist, shiftDtos);

        return newDermatologist;
    }

    @Override
    public Dermatologist removeDermatologistFromPharmacy(Long dermatologistId, Long pharmacyId) {
        if(examinationService.existsByDermatologistIdAndPharmacyId(dermatologistId, pharmacyId))
            throw new RemoveEmployeeException("Dermatologist has scheduled examinations");

        Dermatologist dermatologist = dermatologistRepository.findByIdWithPharmacies(dermatologistId).orElseThrow();
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow();
        List<Pharmacy> pharmacies = dermatologist.getPharmacies();
        pharmacies = pharmacies.stream().filter(p -> !Objects.equals(p.getId(), pharmacy.getId())).collect(Collectors.toList());;
        dermatologist.setPharmacies(pharmacies);
        shiftService.deleteShiftsForEmployee(dermatologistId, pharmacyId);
        return dermatologistRepository.save(dermatologist);
    }

    @NotNull
    private Dermatologist setDermatologistToPharmacy(Long dermatologistId, Long pharmacyId) {
        Dermatologist dermatologist = dermatologistRepository.findByIdWithPharmacies(dermatologistId).orElseThrow();
        if(isAlreadyEmployed(dermatologist, pharmacyId)) throw new AlreadyEmployedException("Dermatologist is already employed");
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow();

        dermatologist.getPharmacies().add(pharmacy);
        return dermatologistRepository.save(dermatologist);
    }

    private boolean isAlreadyEmployed(Dermatologist dermatologist, Long pharmacyId) {
        return dermatologist.getPharmacies().stream()
                .anyMatch(pharmacy -> pharmacy.getId().equals(pharmacyId));
    }
}
