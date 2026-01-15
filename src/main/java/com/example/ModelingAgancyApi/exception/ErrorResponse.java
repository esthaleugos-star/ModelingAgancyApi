package com.example.ModelingAgancyApi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // This creates the constructor with all fields
@NoArgsConstructor  // This creates the empty constructor
public class ErrorResponse {
    private int errorCode;
    private String message;
}