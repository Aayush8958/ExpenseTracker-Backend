package com.example.expenseTracker.Expense;

import com.example.expenseTracker.AppUser.UserService;
import com.example.expenseTracker.AppUser.Appuser;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class ExpenseService {
    ExpenseRepo expenseRepo;
    ExpenseToDTO expenseToDTO;
    UserService userService;

    public ExpenseService(ExpenseRepo expenseRepo, UserService userService, ExpenseToDTO expenseToDTO) {
        this.expenseRepo = expenseRepo;
        this.userService = userService;
        this.expenseToDTO = expenseToDTO;
    }

    public ResponseEntity<String> CreateExpense(ExpenseDto expenseDto){
        Expense expense=new Expense();

        expense.setAmount(expenseDto.getAmount());
        expense.setDate(expenseDto.getDate());
        expense.setCategory(expenseDto.getCategory());
       Appuser user= userService.findById(expenseDto.getUserId());
        expense.setAppuser(user);
        expenseRepo.save(expense);
        return ResponseEntity.ok("Expense Created successfully");
    }
    public ResponseEntity<List<ExpenseResponse>> getExpensesByidandDates(Long id, LocalDate start,LocalDate end){
       List<Expense> expenseList= expenseRepo.findByAppuserIdAndDateBetween(id,start,end);


return  ResponseEntity.ok(expenseToDTO.toDtoList(expenseList));
    }

    public ResponseEntity<List<ExpenseResponse>> getExpensesByidandDate(Long id, LocalDate start){
        List<Expense> expenseList= expenseRepo.findByAppuserIdAndDate(id,start);


        return  ResponseEntity.ok(expenseToDTO.toDtoList(expenseList));
    }

    public ResponseEntity<List<ExpenseResponse>> getExpensesByid(Long id){

        List<Expense> expenseList=expenseRepo.findByAppuserId(id);

        return  ResponseEntity.ok(expenseToDTO.toDtoList(expenseList));
    }
@Transactional
    public ResponseEntity<String> DeleteExpense(Long id ){
        expenseRepo.deleteById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.ACCEPTED);
    }
    @Transactional
    public ResponseEntity<String> updateDate(Long id,LocalDate date){
       Optional<Expense> Optionalexpense= expenseRepo.findById(id);

        Expense expense=Optionalexpense.get();
        expense.setDate(date);
    return new ResponseEntity<>("Date updated",HttpStatus.CREATED);
    }
    @Transactional
    public ResponseEntity<String> updateAmount(Long id, BigDecimal amount){
        Optional<Expense> Optionalexpense= expenseRepo.findById(id);

        Expense expense=Optionalexpense.get();
        expense.setAmount(amount);
        return new ResponseEntity<>("amount updated",HttpStatus.CREATED);
    }


}
