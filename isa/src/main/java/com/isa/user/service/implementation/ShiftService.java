package com.isa.user.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.user.exception.ShiftAlreadyExistsException;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;
import com.isa.user.exception.ShiftsOverlappingException;
import com.isa.user.repository.DermatologistRepository;
import com.isa.user.repository.ShiftRepository;
import com.isa.user.service.interfaces.IShiftService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService implements IShiftService {

    private final ShiftRepository shiftRepository;
    private final DermatologistRepository dermatologistRepository;
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository, DermatologistRepository dermatologistRepository, PharmacyRepository pharmacyRepository) {
        this.shiftRepository = shiftRepository;
        this.dermatologistRepository = dermatologistRepository;
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Shift> getAllByEmployeeId(Long id) {
        return shiftRepository.getAllByEmployeeId(id);
    }

    @Override
    public List<Shift> deleteShiftsByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public List<Shift> deleteShiftsForEmployee(Long dermatologistId, Long pharmacyId) {
        List<Shift> shifts = getAllByEmployeeIdAndPharmacyId(dermatologistId, pharmacyId);
        shiftRepository.deleteAll(shifts);
        return null;
    }

    @Override
    public List<Shift> getAllByEmployeeIdAndPharmacyId(Long employeeId, Long pharmacyId) {
        return shiftRepository.getAllByEmployeeIdAndPharmacyId(employeeId, pharmacyId);
    }

    @Override
    public Shift createForDermatologist(ShiftDto shiftDto) {
        Dermatologist dermatologist = dermatologistRepository.findByIdAndPharmacyId(shiftDto.getPharmacyId(), shiftDto.getEmployeeId()).orElseThrow();
        return createShift(dermatologist, shiftDto);
    }

    @Override
    public void createForDermatologist(Long dermatologistId, Long pharmacyId,  List<ShiftDto> shiftDtos) {
        Dermatologist dermatologist = dermatologistRepository.findByIdAndPharmacyId(pharmacyId, dermatologistId).orElseThrow();
    }

    @Override
    public Shift createForDermatologist(Dermatologist dermatologist, ShiftDto shiftDto) {
        return createShift(dermatologist, shiftDto);
    }

    @Override
    public void createForDermatologist(Dermatologist dermatologist, List<ShiftDto> shifts) {
        shifts.forEach(shiftDto -> createShift(dermatologist, shiftDto));
    }

    @NotNull
    private Shift createShift(Dermatologist dermatologist, ShiftDto shiftDto) {
        Pharmacy pharmacy = pharmacyRepository.findById(shiftDto.getPharmacyId()).orElseThrow();

        TimePeriod duration = new TimePeriod(shiftDto.getStart(), shiftDto.getEnd());
        Shift shift = new Shift();
        shift.setDuration(duration);
        shift.setEmployee(dermatologist);
        shift.setPharmacy(pharmacy);

        if (shiftRepository.exists(shift)) throw new ShiftAlreadyExistsException(duration);
        if (isOverLapping(shift, shift.getEmployee().getId()))
            throw new ShiftsOverlappingException(duration);
        return shiftRepository.save(shift);
    }

    private boolean isOverLapping(Shift shift, Long employeeId) {
        List<Shift> shifts = shiftRepository.getAllByEmployeeId(employeeId);
        if(shifts.size() == 0) return false;
        for(Shift it : shifts) {

            boolean isBefore = isShiftBefore(shift, it);
            boolean isAfter = isShiftAfter(shift, it);

            if(!isAfter && !isBefore) {
                return true;
            }
        }
        return false;

    }

    private boolean isShiftAfter(Shift shift, Shift it) {
        return shift.getDuration().getStart().isAfter(it.getDuration().getEnd())
                && shift.getDuration().getEnd().isAfter(it.getDuration().getEnd());
    }

    private boolean isShiftBefore(Shift shift, Shift it) {
        return shift.getDuration().getStart().isBefore(it.getDuration().getStart())
                && shift.getDuration().getEnd().isBefore(it.getDuration().getStart());
    }
}
