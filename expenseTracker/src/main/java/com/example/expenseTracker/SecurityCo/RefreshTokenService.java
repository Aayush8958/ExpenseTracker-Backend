package com.example.expenseTracker.SecurityCo;

import com.example.expenseTracker.AppUser.UserService;
import com.example.expenseTracker.ExceptionS.NotFound;
import com.example.expenseTracker.TokenPck.Token;
import com.example.expenseTracker.TokenPck.TokenRepository;
import com.example.expenseTracker.AppUser.Appuser;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenService {
private TokenRepository tokenRepository;
private UserService userService;

@Transactional
    public Token CreateRefreshToken(String username){
    if(!userService.ExistByName(username))
        throw new NotFound("User not found ");
        Appuser appuser=userService.findAppuserName(username);

    tokenRepository.deleteByAppuser(appuser);
    tokenRepository.flush();

    Token token=new Token();
    token.setAppuser(appuser);
    token.setToken(UUID.randomUUID().toString());
    token.setExpiryDate(Instant.now().plus(Duration.ofDays(7)));
    return tokenRepository.save(token);
}

public Token verifyExpiration(Token token){
    if(token.getExpiryDate().compareTo(Instant.now())<0){
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED
                ,"Refresh Token was expired.Please sign in again");
    }
    return token;
}
public Optional<Token> findByToken(String token){
    return tokenRepository.findByToken(token);
}
}
