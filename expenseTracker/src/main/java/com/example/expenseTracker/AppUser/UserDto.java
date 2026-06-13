package com.example.expenseTracker.AppUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotNull(message = "id can't be empty")
    Long id;
    @NotBlank(message = "Usernamae can't be empty")
    String username;
}
