package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.User;
import java.util.Optional; // 👈 Make sure this import is there

public interface UserService {
    User saveUser(User user);

    // 🔍 Changed to Optional to match the Repository and Controller
    Optional<User> findByUsername(String username);
}