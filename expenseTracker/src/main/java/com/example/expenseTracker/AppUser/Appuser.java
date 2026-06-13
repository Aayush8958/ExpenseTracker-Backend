package com.example.expenseTracker.AppUser;
import com.example.expenseTracker.Expense.Expense;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
   private String password;
    @OneToMany(mappedBy = "appuser",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
   private List<Expense> expense= new ArrayList<>();
}
