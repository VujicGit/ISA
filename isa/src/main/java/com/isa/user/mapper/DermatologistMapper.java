package com.isa.user.mapper;

import com.isa.user.domain.Dermatologist;
import com.isa.user.dto.DermatologistDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DermatologistMapper {
    public List<DermatologistDto> mapDermatologistsToDermatologistDtos(List<Dermatologist> dermatologists) {
        List<DermatologistDto> retVal = new ArrayList<>();
        for(Dermatologist it : dermatologists) {
            DermatologistDto dermatologistDto = new DermatologistDto(it.getName(), it.getSurname());
            retVal.add(dermatologistDto);
        }

        return retVal;
    }
}
