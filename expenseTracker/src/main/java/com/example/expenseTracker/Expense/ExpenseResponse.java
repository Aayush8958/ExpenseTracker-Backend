package com.example.expenseTracker.Expense;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@RequiredArgsConstructor
public class ExpenseResponse {
    private BigDecimal amoount;
    private Date date;

    @Enumerated(EnumType.STRING)
    private ExpenseEnum cataegory;
}
