package com.bdelas.microservice3gateway.service;

import com.bdelas.microservice3gateway.model.User;
import com.bdelas.microservice3gateway.security.UserPrincipal;
import com.bdelas.microservice3gateway.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements Authenticationservice{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJJWT(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUsername(),
                        signInRequest.getPassword()
                )
        );
        UserPrincipal userPrincipal = (UserPrincipal)  authentication.getPrincipal();

        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();

        signInUser.setToken(jwt);

        return signInUser;
    }
}
