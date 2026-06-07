package com.example.expenseTracker.appUser;
import com.example.expenseTracker.Expense.expense;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class appuser {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
   String name;
   String password;
    @OneToMany(mappedBy = "appuser",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
   private List<expense> expense= new ArrayList<>();
}
