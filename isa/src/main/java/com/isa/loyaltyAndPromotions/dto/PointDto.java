package com.isa.loyaltyAndPromotions.dto;

import com.isa.loyaltyAndPromotions.validator.point.PointsValidation;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PointDto {

    @PointsValidation
    private Integer examinationPoints;

    @PointsValidation
    private Integer consultationPoints;

    public PointDto(Integer examinationPoints, Integer consultationPoints) {
        this.examinationPoints = examinationPoints;
        this.consultationPoints = consultationPoints;
    }

    public Integer getExaminationPoints() {
        return examinationPoints;
    }

    public Integer getConsultationPoints() {
        return consultationPoints;
    }

    public void setExaminationPoints(Integer examinationPoints) {
        this.examinationPoints = examinationPoints;
    }

    public void setConsultationPoints(Integer consultationPoints) {
        this.consultationPoints = consultationPoints;
    }
}
