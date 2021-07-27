package com.isa.evaluation.domain;

import com.isa.evaluation.domain.enumeration.GradeType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Grade {

    private static final int MIN_GRADE = 0;
    private static final int MAX_GRADE = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Min(value = MIN_GRADE, message = "Grade can not be lower than 0")
    @Max(value = MAX_GRADE, message = "Grade can not be greater than 5")
    @NotNull(message = "Grade can not be null")
    private Integer grade;

    @NotNull(message = "Grade type can not be null")
    private GradeType gradeType;

    //Add patient

    public Grade() {
    }

    public Grade(Long id, Integer grade, GradeType gradeType) {
        this.id = id;
        this.grade = grade;
        this.gradeType = gradeType;
    }

    public Long getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public GradeType getGradeType() {
        return gradeType;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setGradeType(GradeType gradeType) {
        this.gradeType = gradeType;
    }
}
