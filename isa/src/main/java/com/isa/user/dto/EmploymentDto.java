package com.isa.user.dto;

import java.util.List;

public class EmploymentDto {

    private Long dermatologistId;
    private List<ShiftDto> shiftDtos;

    public EmploymentDto() {
    }

    public EmploymentDto(Long dermatologistId, List<ShiftDto> shiftDto) {
        this.dermatologistId = dermatologistId;
        this.shiftDtos = shiftDto;
    }

    public Long getDermatologistId() {
        return dermatologistId;
    }

    public List<ShiftDto> getShiftDtos() {
        return shiftDtos;
    }

    public void setDermatologistId(Long dermatologistId) {
        this.dermatologistId = dermatologistId;
    }

    public void setShiftDtos(List<ShiftDto> shiftDtos) {
        this.shiftDtos = shiftDtos;
    }
}
