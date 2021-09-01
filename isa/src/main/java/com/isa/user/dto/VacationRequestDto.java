package com.isa.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.enumeration.VacationRequestStatus;

import java.time.LocalDateTime;

public class VacationRequestDto {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime start;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime end;
    private VacationRequestStatus status;
    private String name;
    private String surname;

    public VacationRequestDto() {
    }

    public VacationRequestDto(LocalDateTime start, LocalDateTime end, VacationRequestStatus status, String name, String surname) {
        this.start = start;
        this.end = end;
        this.status = status;
        this.name = name;
        this.surname = surname;
    }

    public VacationRequestDto(DermatologistVacationRequest dermatologistVacationRequest) {
        this.start = dermatologistVacationRequest.getVacationTime().getStart();
        this.end = dermatologistVacationRequest.getVacationTime().getEnd();
        this.status = dermatologistVacationRequest.getStatus();
        this.name = dermatologistVacationRequest.getDermatologist().getName();
        this.surname = dermatologistVacationRequest.getDermatologist().getSurname();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public VacationRequestStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setStatus(VacationRequestStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
