package com.bdelas.microservice3gateway.security.jwt;

import com.bdelas.microservice3gateway.security.UserPrincipal;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    // propiedad de los lenguajes al interior del token
    Claims extractClaims(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
