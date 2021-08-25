package com.isa.security.auth;

import com.isa.security.dto.UserTokenState;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.domain.User;
import com.isa.user.domain.enumeration.Role;
import com.isa.user.dto.JwtAuthenticationRequest;
import com.isa.user.exception.InvalidCredentialsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthentication {

    private JwtAuthenticationRequest request;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;


    public CustomAuthentication(AuthenticationManager authenticationManager, TokenUtils tokenUtils) {
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
    }

    public UserTokenState authenticate() {

        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = (User) authentication.getPrincipal();
        String jwt = null;
        if(isPharmacyAdministrator(user)) {
            jwt = authenticatePharmacyAdministrator((PharmacyAdministrator) user);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new UserTokenState(jwt, TokenExpiresIn(), user.getRole(), user.getId());
    }

    private boolean isPharmacyAdministrator(User user) {
        return user instanceof PharmacyAdministrator;
    }


    private String authenticatePharmacyAdministrator(PharmacyAdministrator pharmacyAdministrator) throws InvalidCredentialsException {
        if(!request.getPharmacyId().equals(pharmacyAdministrator.getPharmacyId()))
            throw new InvalidCredentialsException("Invalid username or password");
        return tokenUtils.generateToken(pharmacyAdministrator.getEmail(), pharmacyAdministrator.getPharmacyId());
    }

    public void setRequest(JwtAuthenticationRequest request) {
        this.request = request;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public int TokenExpiresIn() {
        return tokenUtils.getExpiredIn();
    }

}
