package com.isa.user.domain;

import com.isa.user.domain.enumeration.VacationRequestStatus;

import javax.persistence.*;
import java.util.Date;

public class PharmacistVacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String adminResponse;
    private VacationRequestStatus status;
    private Pharmacist pharmacist;
    //add time period, pharmacy

    public PharmacistVacationRequest() {}

    public PharmacistVacationRequest(Long id, Date date, String adminResponse, VacationRequestStatus status, Pharmacist pharmacist) {
        this.id = id;
        this.date = date;
        this.adminResponse = adminResponse;
        this.status = status;
        this.pharmacist = pharmacist;
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

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }
}
