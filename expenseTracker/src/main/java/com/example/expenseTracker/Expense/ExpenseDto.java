package com.example.expenseTracker.Expense;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    @NotNull(message = "id can't be empty")
    private Long id;
    @NotNull(message = "Userid can't be empty")
    private Long userId;
    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
    private BigDecimal amount;
    @NotNull(message = "date can't be empty")
    private LocalDate date;
    @NotNull(message = "category can't be empty")
    private ExpenseEnum category;


}
