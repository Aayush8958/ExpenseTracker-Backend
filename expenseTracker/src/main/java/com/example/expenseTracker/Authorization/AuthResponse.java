package com.example.expenseTracker.Authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
private String generatedToken;
private String refreshToken;
}
