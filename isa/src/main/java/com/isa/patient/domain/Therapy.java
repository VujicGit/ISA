package com.isa.patient.domain;

import com.isa.drug.domain.Contraindication;
import com.isa.drug.domain.Drug;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Therapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int duration;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private AppointmentReport appointmentReport;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "therapy_drugs",
            joinColumns = @JoinColumn(name = "therapy_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Drug> drugs;


    public Therapy(){

    }

    public Therapy(Long id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AppointmentReport getAppointmentReport() {
        return appointmentReport;
    }

    public void setAppointmentReport(AppointmentReport appointmentReport) {
        this.appointmentReport = appointmentReport;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }


}
