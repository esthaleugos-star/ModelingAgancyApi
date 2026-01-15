package com.example.ModelingAgancyApi.controller;

import com.example.ModelingAgancyApi.dto.LoginRequest;
import com.example.ModelingAgancyApi.model.User;
import com.example.ModelingAgancyApi.security.JwtUtils;
import com.example.ModelingAgancyApi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Authentication", description = "Endpoints for User Login and Registration")
// This ensures the "Lock" icon appears for all methods in this controller
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    @Operation(summary = "Login to get JWT token")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.findByUsername(loginRequest.getUsername())
                .map(user -> {
                    // 1. Compare the raw password with the encoded one in DB
                    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

                        // 2. Generate the JWT key using the correct method name
                        String token = jwtUtils.generateTokenFromUsername(user.getUsername());

                        // 3. Return as a Map so it shows as JSON in Swagger
                        return ResponseEntity.ok(Map.of(
                                "accessToken", token,
                                "tokenType", "Bearer"
                        ));
                    }
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found"));
    }
}