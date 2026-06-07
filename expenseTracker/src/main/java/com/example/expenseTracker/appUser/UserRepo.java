package com.example.expenseTracker.appUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<appuser,Integer> {
    public boolean existsByUsername(String Username);
    public appuser getByUsername(String Username);
}
