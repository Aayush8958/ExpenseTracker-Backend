package com.example.expenseTracker.Expense;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
public class ExpenseResponse {
    private BigDecimal amount;
    private Date date;


    private ExpenseEnum category;
}
