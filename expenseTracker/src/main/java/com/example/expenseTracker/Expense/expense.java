package com.example.expenseTracker.Expense;

import com.example.expenseTracker.appUser.appuser;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table
public class expense {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

  private   BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private ExpenseEnum category;


   private LocalDate date;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "Userid")
   private appuser appuser;
}
