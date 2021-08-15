package com.isa.user.mapper;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.SearchDermatologistDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DermatologistMapper {

    public static List<SearchDermatologistDto> mapDermatologistsToDermatologistDtos(List<Dermatologist> dermatologists) {
        return dermatologists.stream().map(SearchDermatologistDto::new).collect(Collectors.toList());
    }
}
