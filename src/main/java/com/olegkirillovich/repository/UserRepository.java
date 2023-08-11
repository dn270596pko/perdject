package com.olegkirillovich.repository;

import com.olegkirillovich.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByIdAndRoles_Name(Long id, String roleName);

    // Другие методы ебану позже
}
