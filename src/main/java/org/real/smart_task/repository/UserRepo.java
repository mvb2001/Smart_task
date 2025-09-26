package org.real.smart_task.repository;

import org.real.smart_task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);


    Optional<User> findByEmail(String email);
}
