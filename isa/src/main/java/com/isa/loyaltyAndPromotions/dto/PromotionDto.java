package com.isa.loyaltyAndPromotions.dto;

import com.isa.loyaltyAndPromotions.domain.Promotion;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PromotionDto {

    @NotNull(message = "Description can not be null")
    private String description;

    @NotNull(message = "Start date can not be null")
    private LocalDateTime start;

    @NotNull(message = "End date can not be null")
    private LocalDateTime end;

    public PromotionDto() {
    }

    public PromotionDto(String description, LocalDateTime start, LocalDateTime end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public PromotionDto(Promotion promotion) {
        this.description = promotion.getDescription();
        this.start = promotion.getTimePeriod().getStart();
        this.end = promotion.getTimePeriod().getEnd();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
