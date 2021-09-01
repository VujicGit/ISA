package com.isa.user.mapper;

import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;

import java.util.List;
import java.util.stream.Collectors;

public class ShiftMapper {

    public static List<ShiftDto> mapShiftsToShiftDtos(List<Shift> shifts) {
        return shifts.stream().map(ShiftDto::new).collect(Collectors.toList());
    }
}
