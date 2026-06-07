package com.example.expenseTracker.Expense;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-07T18:48:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ExpenseToDTOImpl implements ExpenseToDTO {

    @Override
    public ExpenseDto toDto(expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setId( expense.getId() );
        expenseDto.setAmoount( expense.getAmoount() );
        expenseDto.setDate( expense.getDate() );
        expenseDto.setCataegory( expense.getCataegory() );

        return expenseDto;
    }
}
