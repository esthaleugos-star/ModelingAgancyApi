package com.example.ModelingAgancyApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "models")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Double height;
    private Integer age;
    private String gender;
}