package com.isa.user.controller;

import com.isa.security.auth.CustomAuthentication;
import com.isa.security.dto.UserTokenState;
import com.isa.user.dto.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    private long calculateExpirationTime() {
        return new Timestamp(System.currentTimeMillis()).getTime() + customAuthentication.TokenExpiresIn();
    }

}
