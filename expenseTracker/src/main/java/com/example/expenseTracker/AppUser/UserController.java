package com.example.expenseTracker.AppUser;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> Signup(@Valid @RequestBody signupRequest signupRequest){
        userService.CreateSignUp(signupRequest);
        return ResponseEntity.ok("account created successfully");
    }

}
