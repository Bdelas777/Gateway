package com.bdelas.microservice3gateway.controller;

import com.bdelas.microservice3gateway.model.User;
import com.bdelas.microservice3gateway.service.Authenticationservice;
import com.bdelas.microservice3gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private Authenticationservice authenticationservice;

    @Autowired
    private UserService userService;

    // registro de usuario
    @PostMapping("sign-up")
    public ResponseEntity<?> signUp (@RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // Iniciar sesion
    @PostMapping("sign-in")
    public ResponseEntity<?> signIn (@RequestBody User user) {
        return new ResponseEntity<>(authenticationservice.signInAndReturnJJWT(user), HttpStatus.OK);
    }
}
