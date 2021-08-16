package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Price;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PriceDto {

    private String drugName;
    private String drugCode;
    private Long drugId;
    private Double price;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;

    public PriceDto() {

    }

    public PriceDto(Price price) {
        this.drugCode = price.getDrug().getCode();
        this.drugName = price.getDrug().getName();
        this.price = price.getPrice();
        this.drugId = price.getDrug().getId();
        this.startPeriod = price.getPriceTime().getStart();
        this.endPeriod = price.getPriceTime().getEnd();
    }

    public PriceDto(String drugName, String drugCode, Double price, Long drugId, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.price = price;
        this.drugId = drugId;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public LocalDateTime getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDateTime startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDateTime getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDateTime endPeriod) {
        this.endPeriod = endPeriod;
    }
}
