package com.example.expenseTracker.Expense;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    ExpenseService expenseService;

    @PostMapping("/ExpenseCreation")
    public ResponseEntity<String> NewExpense(@RequestBody ExpenseDto expenseDto){
        expenseService.CreateExpense(expenseDto);
        return ResponseEntity.ok("expense created successfully");
    }

    @GetMapping("/expensesByid/{id}")
    public ResponseEntity<List<ExpenseResponse>> Expensesbyid(@PathVariable Long id){
            return expenseService.getExpensesByid(id);
    }
    @GetMapping("/expensesByidandDates/{id}/{start}/{end}")
    public ResponseEntity<List<ExpenseResponse>> ExpensesbyidandDates(@PathVariable Long id
            , @PathVariable LocalDate start
            ,@PathVariable LocalDate end){
        return expenseService.getExpensesByidandDates(id, start, end);
    }

    @GetMapping("/expensesByidandDate/{id}/{start}")
    public ResponseEntity<List<ExpenseResponse>> ExpensesbyidandDate(@PathVariable Long id
            , @PathVariable LocalDate start){

        return expenseService.getExpensesByidandDate(id, start);
    }


}
