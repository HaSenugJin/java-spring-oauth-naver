package org.example.loginapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(@Param("email") String email);

    User findByUsername(@Param("username") String username);
}
