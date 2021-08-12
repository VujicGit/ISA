package com.isa.user.mapper;

import com.isa.user.domain.Pharmacist;
import com.isa.user.dto.SearchPharmacistDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PharmacistMapper {

    public List<SearchPharmacistDto> mapPharmacistsToSearchPharmacistDtos(List<Pharmacist> pharmacists) {
        List<SearchPharmacistDto> retVal = new ArrayList<>();
        for (Pharmacist it : pharmacists) {
            SearchPharmacistDto pharmacistDto = new SearchPharmacistDto(it.getName(), it.getSurname(), it.getPharmacy().getDescription(), it.getGrade());
            retVal.add(pharmacistDto);
        }

        return retVal;
    }
}
