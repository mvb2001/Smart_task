package org.real.smart_task.repository;

import org.real.smart_task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    // Find a user by ID safely using Optional
    Optional<User> findById(Long id);

    // Find a user by email safely using Optional
    Optional<User> findByEmail(String email);
}
