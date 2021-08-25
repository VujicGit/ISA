package com.isa.security.auth;

import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenUtils {

    @Value("isa-pharmacy")
    private String APP_NAME;

    @Value("kvOB94tCgxlATWV")
    private String SECRET;

    @Value("604800000")
    private int EXPIRES_IN;

    @Value("Authorization")
    private String AUTH_HEADER;

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String generateToken(String email, Long pharmacyId) {

        return Jwts.builder()
                .setIssuer(APP_NAME)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .claim("pharmacyId", pharmacyId)
                .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
    }

    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + EXPIRES_IN);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        boolean isPharmacyAdminValid = true;
        if(user instanceof PharmacyAdministrator) {
            isPharmacyAdminValid = validatePharmacyAdmin(token, (PharmacyAdministrator) user);
        }
        final String email = getEmailFromToken(token);
        final Date dateCreated = getIssuedAtDateFromToken(token);

        boolean isUserDetailsValid = (email != null && email.equals(((User) userDetails).getEmail()));

        return isUserDetailsValid && isPharmacyAdminValid;

    }

    public Boolean validatePharmacyAdmin(String token, PharmacyAdministrator pharmacyAdministrator) {
        Long pharmacyId = getPharmacyId(token);
        return Objects.equals(pharmacyAdministrator.getPharmacyId(), pharmacyId);
    }

    public String getEmailFromToken(String token) {
        String username;
        try {
            final Claims claims = getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Long getPharmacyId(String token) {
        Long pharmacyId = 0L;
        try {
            final Claims claims = getAllClaimsFromToken(token);
            Integer id = (Integer) claims.get("pharmacyId");
            pharmacyId = id.longValue();
        } catch (Exception e) {
            pharmacyId = null;
        }
        return pharmacyId;
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);

        // JWT se prosledjuje kroz header Authorization u formatu:
        // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public int getExpiredIn() {
        return EXPIRES_IN;
    }

    private String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }
}
