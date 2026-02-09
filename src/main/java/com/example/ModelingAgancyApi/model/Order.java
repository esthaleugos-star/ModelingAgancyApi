package com.example.ModelingAgancyApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingDate;
    private Double totalAmount;

    // ✅ Order exposes client (THIS is correct)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // ✅ Order exposes product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
