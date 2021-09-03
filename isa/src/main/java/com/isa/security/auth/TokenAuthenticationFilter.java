package com.isa.security.auth;

import com.isa.user.domain.User;
import com.isa.user.exception.PasswordNotChangedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;
    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String email;
        String authToken = tokenUtils.getToken(httpServletRequest);


        if(authToken != null) {

            email = tokenUtils.getEmailFromToken(authToken);

            if(email != null) {

                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                if(tokenUtils.validateToken(authToken, userDetails)) {
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    User u = (User) authentication.getPrincipal();
                    isPasswordChanged(httpServletRequest, u);
                    authentication.setToken(authToken);
                    authentication.setAuthenticated(true);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void isPasswordChanged(HttpServletRequest request, User u) {
        String path = request.getServletPath();
        boolean isChanged = u.isPasswordChanged();
        if(!path.equals("/auth/changePassword")) {
            if(!isChanged) throw new PasswordNotChangedException("You must change your password");
        }

    }
}
