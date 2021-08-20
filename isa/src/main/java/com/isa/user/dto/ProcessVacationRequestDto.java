package com.isa.user.dto;

import com.isa.user.domain.enumeration.VacationRequestStatus;

public class ProcessVacationRequestDto {

    private Long id;
    private VacationRequestStatus status;
    private String message;

    public ProcessVacationRequestDto(Long id, VacationRequestStatus status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VacationRequestStatus getStatus() {
        return status;
    }

    public void setStatus(VacationRequestStatus status) {
        this.status = status;
    }
}
