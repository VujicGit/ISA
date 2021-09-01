package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentStatus;
import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.drug.domain.Allergy;
import com.isa.patient.domain.Therapy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Patient;

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
    private Therapy threapy;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "appointmentStartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "appointmentEndTime"))
    })
    private TimePeriod appointmentDuration;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @Column(name = "pharmacy_id", updatable = false, insertable = false)
    private Long pharmacyId;

    public Appointment() {
    }

    public Appointment(Long id, Double cost, AppointmentType type, AppointmentStatus status, Therapy threapy, TimePeriod appointmentPeriod, Patient patient, Pharmacy pharmacy) {
        this.id = id;
        this.cost = cost;
        this.type = type;
        this.status = status;
        this.threapy = threapy;
        this.appointmentDuration = appointmentPeriod;
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

    public Therapy getThreapy() { return threapy; }

    public void setThreapy(Therapy threapy) { this.threapy = threapy; }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TimePeriod getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(TimePeriod appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }
}
