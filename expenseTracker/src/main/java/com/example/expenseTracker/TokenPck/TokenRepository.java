package com.example.expenseTracker.TokenPck;

import com.example.expenseTracker.AppUser.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
Optional<Token> findByToken(String tkn);
void deleteByAppuser(Appuser appuser);
}
