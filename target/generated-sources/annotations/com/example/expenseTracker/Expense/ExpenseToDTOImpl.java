package com.example.expenseTracker.Expense;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-10T03:04:29+0530",
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
        expenseDto.setAmount( expense.getAmount() );
        expenseDto.setDate( expense.getDate() );
        expenseDto.setCategory( expense.getCategory() );

        return expenseDto;
    }

    @Override
    public ExpenseResponse toDTO(expense expense) {
        if ( expense == null ) {
            return null;
        }

        BigDecimal amount = null;
        Date date = null;
        ExpenseEnum category = null;

        amount = expense.getAmount();
        if ( expense.getDate() != null ) {
            date = Date.from( expense.getDate().atStartOfDay( ZoneOffset.UTC ).toInstant() );
        }
        category = expense.getCategory();

        ExpenseResponse expenseResponse = new ExpenseResponse( amount, date, category );

        return expenseResponse;
    }

    @Override
    public List<ExpenseResponse> toDtoList(List<expense> expenseList) {
        if ( expenseList == null ) {
            return null;
        }

        List<ExpenseResponse> list = new ArrayList<ExpenseResponse>( expenseList.size() );
        for ( expense expense : expenseList ) {
            list.add( toDTO( expense ) );
        }

        return list;
    }
}
