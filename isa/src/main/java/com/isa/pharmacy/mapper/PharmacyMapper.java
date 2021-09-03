package com.isa.pharmacy.mapper;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;
import com.isa.pharmacy.dto.SimplePharmacyDto;

import java.util.List;
import java.util.stream.Collectors;

public class PharmacyMapper {

    public static List<PharmacyDto> mapPharmaciesToPharmacyDtos(List<Pharmacy> pharmacies) {
        return pharmacies.stream().map(PharmacyDto::new).collect(Collectors.toList());
    }

    public static List<SimplePharmacyDto> mapPharmaciesToSimplePharmacyDtos(List<Pharmacy> pharmacies) {
        return pharmacies.stream().map(SimplePharmacyDto::new).collect(Collectors.toList());
    }

    public static PharmacyDto mapPharmacyToPharmacyDto(Pharmacy pharmacy) {
        return new PharmacyDto(pharmacy);
    }
}
