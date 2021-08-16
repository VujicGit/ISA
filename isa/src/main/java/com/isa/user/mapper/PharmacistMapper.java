package com.isa.user.mapper;

import com.isa.user.domain.Pharmacist;
import com.isa.user.dto.SearchPharmacistDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PharmacistMapper {

    public static List<SearchPharmacistDto> mapPharmacistsToSearchPharmacistDtos(List<Pharmacist> pharmacists) {
        return pharmacists.stream().map(SearchPharmacistDto::new).collect(Collectors.toList());
    }
}
