package com.example.expenseTracker.Expense;

import com.example.expenseTracker.appUser.appuser;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table
public class expense {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

  private   BigDecimal amoount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Cataegory")
    private ExpenseEnum cataegory;


   private Date date;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "Userid")
   private appuser appuser;
}
