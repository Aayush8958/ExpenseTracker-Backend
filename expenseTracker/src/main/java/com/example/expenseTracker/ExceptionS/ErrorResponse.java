package com.example.expenseTracker.ExceptionS;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Data
@RequiredArgsConstructor
public class ErrorResponse {
   private  final LocalDateTime timestamp;
   private  final String message;
   private final Map<String ,String> errors;
   private final HttpStatus httpStatus;




}
