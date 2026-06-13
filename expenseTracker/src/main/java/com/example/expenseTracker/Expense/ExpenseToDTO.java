package com.example.expenseTracker.Expense;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseToDTO {

    ExpenseDto toDto(Expense expense);
  //  List<ExpenseDto> toDTOList(List<expense> expenseList);

    ExpenseResponse toDTO(Expense expense);
    List<ExpenseResponse> toDtoList(List<Expense> expenseList);

}
