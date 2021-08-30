package com.isa.pharmacy.dto;

import com.isa.pharmacy.exception.PriceTimeException;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AddPriceDto {

    @NotNull
    private Long drugId;
    @NotNull
    private Double price;
    @NotNull
    private LocalDateTime startPeriod;
    @NotNull
    private LocalDateTime endPeriod;

    public AddPriceDto() {
    }

    public AddPriceDto(Long drugId, Double price, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        validatePriceTime(startPeriod, endPeriod);
        this.drugId = drugId;
        this.price = price;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }

    private void validatePriceTime(LocalDateTime start, LocalDateTime end) throws PriceTimeException {
        if(end.isBefore(start) || start.equals(end)) throw new PriceTimeException("End date must be after start date");
    }

    public Long getDrugId() {
        return drugId;
    }

    public Double getPrice() {
        return price;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDateTime endPeriod) {
        this.endPeriod = endPeriod;
    }

    public LocalDateTime getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDateTime startPeriod) {
        this.startPeriod = startPeriod;
    }
}
