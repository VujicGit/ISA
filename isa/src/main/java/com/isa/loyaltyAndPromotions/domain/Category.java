package com.isa.loyaltyAndPromotions.domain;

import com.isa.loyaltyAndPromotions.validator.discount.DiscountValidation;
import com.isa.loyaltyAndPromotions.validator.point.PointsValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name can not be null")
    private String name;

    @DiscountValidation
    private Double discount;

    @PointsValidation
    private Integer points;

    public Category() {

    }

    public Category(String name, Double discount, Integer points) {
        this.name = name;
        this.discount = discount;
        this.points = points;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getDiscount() {
        return discount;
    }

    public Integer getPoints() {
        return points;
    }






}
