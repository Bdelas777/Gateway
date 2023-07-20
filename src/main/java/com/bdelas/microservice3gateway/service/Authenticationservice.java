package com.bdelas.microservice3gateway.service;

import com.bdelas.microservice3gateway.model.User;

public interface Authenticationservice {
    User signInAndReturnJJWT(User signInRequest);
}
