package com.isa.pharmacy.mapper;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;

import java.util.List;
import java.util.stream.Collectors;

public class PharmacyMapper {

    public static List<PharmacyDto> mapPharmaciesToPharmacyDtos(List<Pharmacy> pharmacies) {
        return pharmacies.stream().map(PharmacyDto::new).collect(Collectors.toList());
    }
}
