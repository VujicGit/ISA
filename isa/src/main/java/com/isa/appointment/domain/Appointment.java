package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentStatus;
import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.drug.domain.Allergy;
import com.isa.patient.domain.Therapy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Patient;
import com.isa.user.domain.Pharmacist;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType=DiscriminatorType.STRING)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double cost;

    @Column
    private AppointmentType type;

    @Column
    private AppointmentStatus status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Therapy therapy;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "appointmentStartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "appointmentEndTime"))
    })
    private TimePeriod appointmentPeriod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Pharmacy pharmacy;

    public Appointment() {
    }

    public Appointment(Long id, Double cost, AppointmentType type, AppointmentStatus status, Therapy therapy, TimePeriod appointmentPeriod, Patient patient, Pharmacy pharmacy) {
        this.id = id;
        this.cost = cost;
        this.type = type;
        this.status = status;
        this.therapy = therapy;
        this.appointmentPeriod = appointmentPeriod;
        this.patient = patient;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public AppointmentType getType() {
        return type;
    }

    public void setType(AppointmentType type) {
        this.type = type;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public TimePeriod getAppointmentPeriod() {
        return appointmentPeriod;
    }

    public void setAppointmentPeriod(TimePeriod appointmentPeriod) {
        this.appointmentPeriod = appointmentPeriod;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
