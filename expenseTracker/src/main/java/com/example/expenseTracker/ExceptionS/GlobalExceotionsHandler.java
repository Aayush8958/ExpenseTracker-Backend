package com.example.expenseTracker.ExceptionS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceotionsHandler {
    @ExceptionHandler(value = {AlreadyExists.class})
    public ResponseEntity<ErrorResponse> Exists(AlreadyExists alreadyExists){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),
                alreadyExists.getMessage(),null,HttpStatus.BAD_REQUEST);

        return new  ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {NotFound.class})
    public ResponseEntity<ErrorResponse> Notfound(NotFound notFound){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),
                notFound.getMessage(),null,HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
