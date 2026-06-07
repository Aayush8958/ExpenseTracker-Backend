package com.example.expenseTracker.Expense;

import com.example.expenseTracker.appUser.appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<expense,Long> {
    List<expense> findByAppuserIdAndDateBetween(
            Long userId,
            Date startDate,
            Date endDate
    );
}
