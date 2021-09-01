package com.isa.user.dto;

import com.isa.user.domain.Shift;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ShiftDto {

    @NotNull(message = "Start date can not be null")
    private LocalDateTime start;
    @NotNull(message = "End date can not be null")
    private LocalDateTime end;
    @NotNull(message = "Pharmacy id can not be null")
    private Long pharmacyId;
    @NotNull(message = "Employee id can not be null")
    private Long employeeId;

    public ShiftDto() {
    }

    public ShiftDto(Shift shift) {
        this.employeeId = shift.getEmployeeId();
        this.pharmacyId = shift.getPharmacyId();
        this.start = shift.getDuration().getStart();
        this.end = shift.getDuration().getEnd();
    }

    public ShiftDto(LocalDateTime start, LocalDateTime end, Long pharmacyId, Long employeeId) {
        this.start = start;
        this.end = end;
        this.pharmacyId = pharmacyId;
        this.employeeId = employeeId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
