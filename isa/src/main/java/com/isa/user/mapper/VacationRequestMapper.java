package com.isa.user.mapper;

import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.dto.VacationRequestDto;

import java.util.List;
import java.util.stream.Collectors;

public class VacationRequestMapper {

    public static List<VacationRequestDto> mapDermatologistVacationRequestsToVacationRequestDtos(List<DermatologistVacationRequest> vacationRequests) {
        return vacationRequests.stream().map(VacationRequestDto::new).collect(Collectors.toList());
    }

    public static VacationRequestDto mapDermatologistVacationRequestToVacationRequestDto(DermatologistVacationRequest vacationRequest) {
        return new VacationRequestDto(vacationRequest);
    }
}
