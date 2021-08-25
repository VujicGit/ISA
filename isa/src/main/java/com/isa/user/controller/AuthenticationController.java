package com.isa.user.controller;

import antlr.Token;
import com.isa.security.auth.TokenUtils;
import com.isa.security.dto.UserTokenState;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.domain.User;
import com.isa.user.domain.enumeration.Role;
import com.isa.user.dto.JwtAuthenticationRequest;
import com.isa.user.service.implementation.CustomUserDetailsService;
import com.isa.user.service.implementation.UserService;
import com.isa.user.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final IUserService userService;

    @Autowired
    public AuthenticationController(TokenUtils tokenUtils, AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, IUserService userService) {
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> authenticate(@RequestBody JwtAuthenticationRequest request, HttpServletResponse response) {

        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwt = null;
        int expiresIn = 0;
        if(user instanceof PharmacyAdministrator) {
            jwt = tokenUtils.generateToken(request.getUsername(), ((PharmacyAdministrator) user).getPharmacyId());
            expiresIn = tokenUtils.getExpiredIn();
        }


        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));

    }
}
