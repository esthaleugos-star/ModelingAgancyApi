package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.User;
import com.example.ModelingAgancyApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 🔍 Adding the new security method
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}