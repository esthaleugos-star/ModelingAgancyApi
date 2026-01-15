package com.example.ModelingAgancyApi.repository;

import com.example.ModelingAgancyApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 🔍 This custom method is the key to security!
    // It allows Spring Security to fetch a user by their login name.
    Optional<User> findByUsername(String username);
}