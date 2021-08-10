package com.isa.patient.domain;



import com.isa.appointment.domain.Appointment;
import com.isa.drug.domain.Allergy;
import com.isa.drug.domain.Drug;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AppointmentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private String diagnosis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private MedicalRecord medicalRecord;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Appointment appointment;

    public AppointmentReport(){

    }
    public AppointmentReport(Long id, Date date, String diagnosis) {
        this.id = id;
        this.date = date;
        this.diagnosis = diagnosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
