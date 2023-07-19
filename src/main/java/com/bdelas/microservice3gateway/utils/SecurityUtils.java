package com.bdelas.microservice3gateway.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {
    public static final String ROLE_PREFIX = "ROLE_";
    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formattedRole);
    }
}
