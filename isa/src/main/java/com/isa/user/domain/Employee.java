package com.isa.user.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee extends User {

    @OneToMany(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "employee_id")
    private List<Shift> shifts;

    public Employee(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public Employee() {

    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
