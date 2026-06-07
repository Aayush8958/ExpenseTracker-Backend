package com.example.expenseTracker.appUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<appuser,Long> {
    public boolean existsByName(String name);

    public appuser getByName(String name);
}
