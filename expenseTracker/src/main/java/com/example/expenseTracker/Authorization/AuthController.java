package com.example.expenseTracker.Authorization;

import com.example.expenseTracker.AppUser.signupRequest;
import com.example.expenseTracker.TokenPck.TokenReq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    AuthService authService;

    @PostMapping("/Login")
    public ResponseEntity<AuthResponse> Login(@RequestBody signupRequest signupRequest){
       return authService.LoginChecker(signupRequest);
    }
        @PostMapping("/Refresh")
    public  ResponseEntity<?> RefereshAccess(@RequestBody TokenReq tokenReq){
        return authService.refreshAccessToken(tokenReq);
    }
}
