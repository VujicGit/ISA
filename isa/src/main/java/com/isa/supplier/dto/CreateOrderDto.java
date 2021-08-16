package com.isa.supplier.dto;

import com.isa.supplier.validator.dueDate.DueDateValidation;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CreateOrderDto {

    private List<CreateOrderedDrugDto> orderedDrugs;

    @DueDateValidation
    @NotNull(message = "Due date can not be null")
    private LocalDate dueDate;

    public CreateOrderDto() {
    }

    public CreateOrderDto(List<CreateOrderedDrugDto> orderedDrugs, LocalDate dueDate) {
        this.orderedDrugs = orderedDrugs;
        this.dueDate = dueDate;
    }

    public List<CreateOrderedDrugDto> getOrderedDrugs() {
        return orderedDrugs;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setOrderedDrugs(List<CreateOrderedDrugDto> orderedDrugs) {
        this.orderedDrugs = orderedDrugs;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
