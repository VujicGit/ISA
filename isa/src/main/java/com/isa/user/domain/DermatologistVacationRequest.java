package com.isa.user.domain;

import com.isa.user.domain.enumeration.VacationRequestStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DermatologistVacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private String adminResponse;

    @Column
    private VacationRequestStatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    private Dermatologist dermatologist;

    // add time period, pharmacy


    public DermatologistVacationRequest() {}

    public DermatologistVacationRequest(Long id, Date date, String adminResponse, VacationRequestStatus status, Dermatologist dermatologist) {
        this.id = id;
        this.date = date;
        this.adminResponse = adminResponse;
        this.status = status;
        this.dermatologist = dermatologist;
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

    public String getAdminResponse() {
        return adminResponse;
    }

    public void setAdminResponse(String adminResponse) {
        this.adminResponse = adminResponse;
    }

    public VacationRequestStatus getStatus() {
        return status;
    }

    public void setStatus(VacationRequestStatus status) {
        this.status = status;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
