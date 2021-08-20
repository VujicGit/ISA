package com.isa.helper.mail.service.mailService.implementation;

import com.isa.helper.mail.dto.MailDto;
import com.isa.helper.mail.service.mailService.interfaces.IMailService;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class MailService implements IMailService {

    private final JavaMailSender javaMailSender;
    private final Environment environment;

    @Autowired
    public MailService(JavaMailSender javaMailSender, Environment environment) {
       this.javaMailSender = javaMailSender;
       this.environment = environment;
    }


    @Override
    @Async
    public void sendMail(MailDto mailDto) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(mailDto.getReceiver());
        mail.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
        mail.setSubject(mailDto.getSubject());
        mail.setText(mailDto.getText());
        try {
            javaMailSender.send(mail);
        }catch (MailException ex) {
            ex.printStackTrace();
        }
    }
}
