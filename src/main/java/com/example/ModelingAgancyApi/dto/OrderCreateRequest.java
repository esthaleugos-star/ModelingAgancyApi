package com.example.ModelingAgancyApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateRequest {

    private String bookingDate;
    private Double totalAmount;
    private Long clientId;
    private Long productId;
}
