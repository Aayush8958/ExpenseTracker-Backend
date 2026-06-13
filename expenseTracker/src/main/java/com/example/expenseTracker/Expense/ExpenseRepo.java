package com.example.expenseTracker.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Long> {
    List<Expense> findByAppuserIdAndDateBetween(
            Long userId,
            LocalDate startDate,
            LocalDate endDate
    );
    List<Expense> findByAppuserIdAndDate(
            Long userId,
            LocalDate startDate
    );

    List<Expense> findByAppuserId(Long userId);


}
