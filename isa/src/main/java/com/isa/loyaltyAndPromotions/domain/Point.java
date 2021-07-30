package com.isa.loyaltyAndPromotions.domain;

import com.isa.loyaltyAndPromotions.validator.point.PointsValidation;
import com.sun.istack.Nullable;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    @PointsValidation
    private Integer examinationPoints;


    @Column(unique = true)
    @PointsValidation
    private Integer consultationPoints;

    public Point() {

    }
    public Point(Integer examinationPoints, Integer consultationPoints) {
        this.examinationPoints = examinationPoints;
        this.consultationPoints = consultationPoints;
    }

    public Long getId() {
        return id;
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
