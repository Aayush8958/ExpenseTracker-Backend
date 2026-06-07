package com.example.expenseTracker.ExceptionS;

public class NotFound extends RuntimeException
{
    public NotFound(String message) {
        super(message);
    }
}
