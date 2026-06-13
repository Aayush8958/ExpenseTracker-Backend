package com.example.expenseTracker.Authorization;

import com.example.expenseTracker.AppUser.Appuser;
import com.example.expenseTracker.AppUser.UserRepo;
import com.example.expenseTracker.AppUser.UserService;
import com.example.expenseTracker.AppUser.signupRequest;
import com.example.expenseTracker.ExceptionS.NotFound;
import com.example.expenseTracker.SecurityCo.RefreshTokenService;
import com.example.expenseTracker.SecurityCo.TokenGenerationService;
import com.example.expenseTracker.TokenPck.Token;
import com.example.expenseTracker.TokenPck.TokenReq;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
UserService userService;
TokenGenerationService tokenGenerationService;
RefreshTokenService refreshTokenService;

public ResponseEntity<AuthResponse> LoginChecker(signupRequest signupRequest){
    if(!userService.ExistByName(signupRequest.getName()))
        throw new NotFound("Invalid username or password ");

    Appuser appuser=userService.findAppuserName(signupRequest.getName());

    boolean password_check= BCrypt.checkpw(signupRequest.getPassword(),appuser.getPassword());
    if(!password_check){
        throw new NotFound("Invalid username or password ");
    }
    String generatedToken=tokenGenerationService.GenerateToken(signupRequest.getName());
    Token refreshToken=refreshTokenService.CreateRefreshToken(appuser.getName());

    return ResponseEntity.ok(new AuthResponse(generatedToken,refreshToken.getToken()));

}
    public ResponseEntity<?> refreshAccessToken(TokenReq tokenReq){

        String requestToken = tokenReq.getToken();


        return refreshTokenService.findByToken(requestToken)
                .map(refreshTokenService::verifyExpiration)
                .map(Token::getAppuser)
                .map(user -> {
                    String newAccessToken = tokenGenerationService.GenerateToken(user.getName());
                    return ResponseEntity.ok(new AuthResponse(newAccessToken, requestToken));
                })
                .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Refresh token is not in database!"));
    }
}
