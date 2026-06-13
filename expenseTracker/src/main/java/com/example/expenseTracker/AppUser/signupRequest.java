package com.example.expenseTracker.AppUser;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class signupRequest {

    @NotBlank(message = "name can't be empty")
    private String name;

@NotBlank(message = "password can't be empty")
    private String password;
}
