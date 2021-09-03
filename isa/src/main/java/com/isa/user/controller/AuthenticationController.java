package com.isa.user.controller;

import com.isa.helper.http.Message;
import com.isa.security.auth.CustomAuthentication;
import com.isa.security.dto.UserTokenState;
import com.isa.user.dto.JwtAuthenticationRequest;
import com.isa.user.dto.PasswordChangerDto;
import com.isa.user.service.implementation.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    
    private final CustomAuthentication customAuthentication;

    @Autowired
    public AuthenticationController(CustomAuthentication customAuthentication) {
        this.customAuthentication = customAuthentication;

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> authenticate(@RequestBody JwtAuthenticationRequest request, HttpServletResponse response) {

        customAuthentication.setRequest(request);
        UserTokenState userTokenState = customAuthentication.authenticate();

        return new ResponseEntity<>(userTokenState, HttpStatus.OK);
    }

    @PostMapping(value = "/changePassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangerDto dto) {
        customAuthentication.changePassword(dto.getOldPassword(), dto.getNewPassword());

        return new ResponseEntity<>(new Message("Your password is changed"), HttpStatus.OK);
    }

    private long calculateExpirationTime() {
        return new Timestamp(System.currentTimeMillis()).getTime() + customAuthentication.TokenExpiresIn();
    }


}
