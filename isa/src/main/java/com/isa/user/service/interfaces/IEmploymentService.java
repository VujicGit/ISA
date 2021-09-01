package com.isa.user.service.interfaces;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.ShiftDto;

import java.util.List;

public interface IEmploymentService {

    Dermatologist employDermatologist(Long dermatologistId, Long pharmacyId, ShiftDto shiftDto);
    Dermatologist employDermatologist(Long dermatologistId, Long pharmacyId, List<ShiftDto> shiftDtos);
    Dermatologist removeDermatologistFromPharmacy(Long dermatologistId, Long pharmacyId);
}
