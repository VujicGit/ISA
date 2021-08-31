package com.isa.user.service.interfaces;

import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;

import java.util.List;

public interface IShiftService {

    List<Shift> getAllByEmployeeId(Long id);
    List<Shift> getAllByEmployeeIdAndPharmacyId(Long employeeId, Long pharmacyId);
    Shift createForDermatologist(ShiftDto shiftDto);
}
