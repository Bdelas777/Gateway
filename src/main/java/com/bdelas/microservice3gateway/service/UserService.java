package com.bdelas.microservice3gateway.service;

import com.bdelas.microservice3gateway.model.Role;
import com.bdelas.microservice3gateway.model.User;

import java.util.Optional;

public interface UserService {
    User UserSave(User user);

    Optional<User> findByUsername(String username);


    void changeRole(Role newRole, String username);
}
