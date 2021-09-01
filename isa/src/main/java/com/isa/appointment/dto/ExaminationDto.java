package com.isa.appointment.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExaminationDto {

    @NotNull(message = "Dermatologist id can not be null")
    private Long dermatologistId;
    @NotNull(message = "Start date can not be null")
    private LocalDateTime start;
    @NotNull(message = "End date can not be null")
    private LocalDateTime end;
    @NotNull(message = "Price can not be null")
    private Double price;

    public ExaminationDto() {
    }

    public ExaminationDto(Long dermatologistId, LocalDateTime start, LocalDateTime end, Double price) {
        this.dermatologistId = dermatologistId;
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public Long getDermatologistId() {
        return dermatologistId;
    }


    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Double getPrice() {
        return price;
    }

    public void setDermatologistId(Long dermatologistId) {
        this.dermatologistId = dermatologistId;
    }


    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
