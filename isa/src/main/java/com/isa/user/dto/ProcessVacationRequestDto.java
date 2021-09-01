package com.isa.user.dto;

import com.isa.user.domain.enumeration.VacationRequestStatus;

import javax.validation.constraints.NotNull;

public class ProcessVacationRequestDto {

    @NotNull(message = "Vacation request id can not be null")
    private Long id;
    @NotNull(message = "Vacation request status can not be null")
    private VacationRequestStatus status;
    @NotNull(message = "Message can not be null")
    private String message;

    public ProcessVacationRequestDto() {
    }

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
