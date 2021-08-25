package com.isa.user.controller;

import com.isa.security.auth.CustomAuthentication;
import com.isa.security.auth.TokenUtils;
import com.isa.security.dto.UserTokenState;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.dto.JwtAuthenticationRequest;
import com.isa.user.exception.InvalidCredentialsException;
import com.isa.user.service.implementation.CustomUserDetailsService;
import com.isa.user.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
        String jwt = customAuthentication.authenticate();
        int expiresIn = customAuthentication.TokenExpiresIn();
        
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

}
