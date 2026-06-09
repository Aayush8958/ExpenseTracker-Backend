package com.example.expenseTracker.appUser;

import com.example.expenseTracker.Expense.ExpenseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> Signup(@RequestBody signupRequest signupRequest){
        userService.CreateSignUp(signupRequest);
        return ResponseEntity.ok("account created successfully");
    }

}
