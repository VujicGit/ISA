package com.isa.user.service.interfaces;

import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Employee;
import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;

import java.util.List;

public interface IShiftService {

    List<Shift> getAllByEmployeeId(Long id);
    List<Shift> deleteShiftsByEmployeeId(Long employeeId);
    List<Shift> deleteShiftsForEmployee(Long dermatologistId, Long pharmacyId);
    List<Shift> getAllByEmployeeIdAndPharmacyId(Long employeeId, Long pharmacyId);
    Shift createForDermatologist(ShiftDto shiftDto);
    void createForDermatologist(Long dermatologistId, Long pharmacyId,  List<ShiftDto> shiftDtos);
    Shift createForDermatologist(Dermatologist dermatologist, ShiftDto shiftDto);
    void createForDermatologist(Dermatologist dermatologist, List<ShiftDto> shifts);
}
