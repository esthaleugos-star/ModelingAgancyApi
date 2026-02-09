package com.example.ModelingAgancyApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Matches DB column: category
    @Column(name = "category")
    private String category;

    // ✅ Matches DB column: name
    @Column(name = "name")
    private String name;

    // ✅ Matches DB column: price
    @Column(name = "price")
    private Double price;

    // ✅ Matches DB column: size
    @Column(name = "size")
    private String size;

    // ✅ Matches DB column: status
    @Column(name = "status")
    private String status;

    // 🔒 Prevent circular JSON
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    // 🔒 Prevent circular JSON
    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Client> clients = new ArrayList<>();
}
