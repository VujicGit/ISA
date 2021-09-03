package com.isa.user.domain;

import com.isa.appointment.domain.TimePeriod;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.enumeration.VacationRequestStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class DermatologistVacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String adminResponse;

    @Column
    private VacationRequestStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "dermatologist_id")
    private Dermatologist dermatologist;

    @Column(name = "dermatologist_id", updatable = false, insertable = false)
    private Long dermatologistId;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @Column(name = "pharmacy_id", updatable = false, insertable = false)
    private Long pharmacyId;

    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "vacationStart")),
            @AttributeOverride( name = "end", column = @Column(name = "vacationEnd"))
    })
    @NotNull(message = "Vacation period can not be null")
    private TimePeriod vacationTime;


    public DermatologistVacationRequest() {}

    public DermatologistVacationRequest(Long id, String adminResponse, VacationRequestStatus status, Dermatologist dermatologist, Pharmacy pharmacy, TimePeriod vacationTime) {
        this.id = id;
        this.adminResponse = adminResponse;
        this.status = status;
        this.dermatologist = dermatologist;
        this.pharmacy = pharmacy;
        this.vacationTime = vacationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public TimePeriod getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(TimePeriod vacationTime) {
        this.vacationTime = vacationTime;
    }

    public Long getDermatologistId() {
        return dermatologistId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }
}
