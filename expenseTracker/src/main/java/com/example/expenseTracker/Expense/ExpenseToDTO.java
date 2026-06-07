package com.example.expenseTracker.Expense;

import com.example.expenseTracker.appUser.UserDto;
import com.example.expenseTracker.appUser.appuser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseToDTO {

    ExpenseDto toDto(expense expense);
  //  List<ExpenseDto> toDTOList(List<expense> expenseList);

    ExpenseResponse toDTO(expense expense);
    List<ExpenseResponse> toDtoList(List<expense> expenseList);

}
