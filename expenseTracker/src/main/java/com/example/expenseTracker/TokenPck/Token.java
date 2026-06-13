package com.example.expenseTracker.TokenPck;

import com.example.expenseTracker.AppUser.Appuser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table
public class Token {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Tid;
    @Column(nullable = false,unique = true)
    private String token;
    @Column(nullable = false)
    private Instant expiryDate;

        @JoinColumn(name = "UserId",referencedColumnName = "id")
            @OneToOne
    private Appuser appuser;
}

