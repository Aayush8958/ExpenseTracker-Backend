package com.example.expenseTracker.Expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDate date;
    private ExpenseEnum category;


}
