package com.bdelas.microservice3gateway.repository;

import com.bdelas.microservice3gateway.model.Role;
import com.bdelas.microservice3gateway.model.User;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    // Encuentra usuario

    Optional<User> findByUsername(String username);

    // Actualiza al usuario
    @Modifying
    @Query("UPDATE USER SET role=:role WHERE Username=:username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);


}
