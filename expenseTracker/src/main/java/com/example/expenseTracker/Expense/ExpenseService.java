package com.example.expenseTracker.Expense;

import com.example.expenseTracker.appUser.UserService;
import com.example.expenseTracker.appUser.appuser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    ExpenseRepo expenseRepo;
    ExpenseToDTO expenseToDTO;
    UserService userService;

    public ResponseEntity<String> CreateExpense(ExpenseDto expenseDto){
        expense expense=new expense();
        expense.setId(expenseDto.getId());
        expense.setAmoount(expenseDto.getAmount());
        expense.setDate(expenseDto.getDate());
       appuser user= userService.findById(expenseDto.getId());
        expense.setAppuser(user);
        expenseRepo.save(expense);
        return ResponseEntity.ok("Expense Created successfully");
    }
    public ResponseEntity<List<ExpenseResponse>> getExpensesByidandDates(Long id, Date start,Date end){
       List<expense> expenseList= expenseRepo.findByAppuserIdAndDateBetween(id,start,end);


return  ResponseEntity.ok(expenseToDTO.toDtoList(expenseList));
    }
}
