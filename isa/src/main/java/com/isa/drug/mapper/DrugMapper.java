package com.isa.drug.mapper;

import com.isa.drug.domain.Drug;
import com.isa.drug.dto.BasicDrugDto;
import com.isa.drug.dto.DrugIdDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<BasicDrugDto> mapDrugsToBasicDrugDtos(List<Drug> drugs) {
        return drugs.stream().map(BasicDrugDto::new).collect(Collectors.toList());
    }
}
