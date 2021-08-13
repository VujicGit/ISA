package com.isa.drug.mapper;

import com.isa.drug.domain.Drug;
import com.isa.drug.dto.DrugIdDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrugMapper {
    public List<DrugIdDto> mapDrugsToDrugIdDtos(List<Drug> drugs) {

        List<DrugIdDto> retVal = new ArrayList<>();
        for (Drug it : drugs) {
            DrugIdDto dto = new DrugIdDto(it.getId());
            retVal.add(dto);
        }

        return retVal;
    }
}
