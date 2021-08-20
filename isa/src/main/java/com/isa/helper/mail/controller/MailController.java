package com.isa.helper.mail.controller;

import com.isa.helper.mail.dto.MailDto;
import com.isa.helper.mail.service.mailService.interfaces.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

    private final IMailService mailService;

    @Autowired
    public MailController(IMailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public ResponseEntity<?> send() {

        mailService.sendMail(new MailDto());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
