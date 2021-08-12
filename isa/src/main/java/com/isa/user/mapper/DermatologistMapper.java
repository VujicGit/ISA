package com.isa.user.mapper;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.SearchDermatologistDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DermatologistMapper {
    public List<SearchDermatologistDto> mapDermatologistsToDermatologistDtos(List<Dermatologist> dermatologists) {
        List<SearchDermatologistDto> retVal = new ArrayList<>();
        for(Dermatologist it : dermatologists) {
            List<String> pharmacies = new ArrayList<>();
            for (Pharmacy pharmacyIt : it.getPharmacies()) {
                pharmacies.add(pharmacyIt.getDescription());
            }
            SearchDermatologistDto searchDermatologistDto = new SearchDermatologistDto(it.getName(), it.getSurname(), pharmacies, it.getGrade());
            retVal.add(searchDermatologistDto);
        }

        return retVal;
    }
}
