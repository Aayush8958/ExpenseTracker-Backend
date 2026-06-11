package com.example.expenseTracker.appUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class signupRequest {

    @NotBlank(message = "name can't be empty")
    private String name;

@NotBlank(message = "password can't be empty")
    private String password;
}
