package com.isa.systemAdmin.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ComplaintResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private String text;

    @OneToOne
    private Complaint complaint;


    public ComplaintResponse() {}

    public ComplaintResponse(Long id, Date date, String text, Complaint complaint) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.complaint = complaint;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
