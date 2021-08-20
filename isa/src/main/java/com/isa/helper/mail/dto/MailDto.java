package com.isa.helper.mail.dto;

public class MailDto {

    private String receiver;
    private String subject;
    private String text;

    public MailDto() {
    }

    public MailDto(String receiver, String subject, String text) {
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
