package com.isa.user.domain;

import com.isa.appointment.domain.TimePeriod;
import com.isa.pharmacy.domain.Pharmacy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "shiftStart")),
            @AttributeOverride( name = "end", column = @Column(name = "shiftEnd"))
    })
    @NotNull(message = "Shift duration can not be null")
    TimePeriod duration;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @Column(name = "pharmacy_id", updatable = false, insertable = false)
    private Long pharmacyId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "employee_id", updatable = false, insertable = false)
    private Long employeeId;


    public Shift() {}

    public Shift(TimePeriod duration, Pharmacy pharmacy, Employee employee) {
        this.duration = duration;
        this.pharmacy = pharmacy;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public TimePeriod getDuration() {
        return duration;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void setDuration(TimePeriod duration) {
        this.duration = duration;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return id.equals(shift.id) && duration.equals(shift.duration) && pharmacyId.equals(shift.pharmacyId) && employeeId.equals(shift.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, pharmacy, pharmacyId, employee, employeeId);
    }
}
