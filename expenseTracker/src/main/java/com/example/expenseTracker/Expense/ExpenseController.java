package com.example.expenseTracker.Expense;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Validated
@RestController
public class ExpenseController {


    ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @PostMapping("/ExpenseCreation")
    public ResponseEntity<String> NewExpense(@Valid @RequestBody ExpenseDto expenseDto){
        expenseService.CreateExpense(expenseDto);
        return ResponseEntity.ok("expense created successfully");
    }

    @GetMapping("/expensesByid/{id}")
    public ResponseEntity<List<ExpenseResponse>> Expensesbyid(@Valid @PathVariable Long id){
            return expenseService.getExpensesByid(id);
    }
    @GetMapping("/expensesByidandDates/{id}/{start}/{end}")
    public ResponseEntity<List<ExpenseResponse>> ExpensesbyidandDates(@Valid @PathVariable Long id
            , @Valid @PathVariable LocalDate start
            ,@Valid @PathVariable LocalDate end){
        return expenseService.getExpensesByidandDates(id, start, end);
    }

    @GetMapping("/expensesByidandDate/{id}/{start}")
    public ResponseEntity<List<ExpenseResponse>> ExpensesbyidandDate(@Valid @PathVariable Long id
            , @Valid @PathVariable LocalDate start){

        return expenseService.getExpensesByidandDate(id, start);
    }
    @DeleteMapping("/expneseDelete/{id}")
    public ResponseEntity<String> ExpenseDelete(@Valid @PathVariable Long id){


        return expenseService.DeleteExpense(id);
    }
    @PatchMapping("/UpdateDate/{id}/{date}")
    public ResponseEntity<String> UpdateDate(@Valid @PathVariable Long id,@Valid @PathVariable LocalDate date){

        return expenseService.updateDate(id,date);
    }
    @PatchMapping("/UpdateAmount/{id}/{amount}")
    public ResponseEntity<String> UpdateAmount(@Valid @PathVariable Long id,@Valid @PathVariable BigDecimal amount){

        return expenseService.updateAmount(id, amount);
    }

}
