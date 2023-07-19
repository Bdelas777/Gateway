package com.bdelas.microservice3gateway.security.jwt;

import com.bdelas.microservice3gateway.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.util.stream.Collectors;
import io.jsonwebtoken.security

public class JwtProviderImpl implements JwtProvider{

    @Value("${app.jwt.secret }")
    private String JWT_SECRET;

    @Value("${app.jwt.expiration-in-ms}")
    private String JWT_EXPIRATION_IN_MS;

    public String generateToken(UserPrincipal auth){
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Key key = Keys.hmac
    }



}
