package com.example.ModelingAgancyApi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data // 👈 This creates the getPassword/setPassword methods automatically!
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;
}