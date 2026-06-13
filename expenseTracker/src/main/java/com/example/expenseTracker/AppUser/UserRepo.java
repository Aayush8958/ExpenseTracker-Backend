package com.example.expenseTracker.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Appuser,Long> {
    public boolean existsByName(String name);

    public Appuser getByName(String name);

    public Appuser findByName(String name);
}
