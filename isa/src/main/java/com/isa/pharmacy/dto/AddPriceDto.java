package com.isa.pharmacy.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class AddPriceDto {

    private Long drugId;
    private Double price;
    private LocalDate startPeriod;
    private LocalDate endPeriod;

    public AddPriceDto() {
    }

    public AddPriceDto(Long drugId, Double price, LocalDate startPeriod, LocalDate endPeriod) {
        this.drugId = drugId;
        this.price = price;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
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

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    public LocalDate getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDate startPeriod) {
        this.startPeriod = startPeriod;
    }
}
