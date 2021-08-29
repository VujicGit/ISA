package com.isa.loyaltyAndPromotions.domain;

import com.isa.loyaltyAndPromotions.validator.point.PointsValidation;

import javax.persistence.*;

@Entity
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PointsValidation
    private Integer points;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    private Category category;

    //Add patient

    public Loyalty() {
    }

    public Loyalty(Integer points, Category category) {
        this.points = points;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public Integer getPoints() {
        return points;
    }

    public Category getCategory() {
        return category;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
