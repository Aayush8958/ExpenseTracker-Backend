package com.example.expenseTracker.ExceptionS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> HandleInvalidData(MethodArgumentNotValidException InvalidData){
        Map<String,String> errors=new HashMap<>();
        for(FieldError error: InvalidData.getBindingResult().getFieldErrors()){
            errors.put(error.getField(),error.getDefaultMessage());
        }
        ErrorResponse errorbody=new ErrorResponse(LocalDateTime.now()
                ,"Not valid data type"
                ,errors,HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(errorbody,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> HandleInvalidDataType(MethodArgumentTypeMismatchException InvalidDataType){
        ErrorResponse errorbody=new ErrorResponse(LocalDateTime.now(),
                "Invalid Data Type used",
                null,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(errorbody,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> HandleInvalidDataTypeInJSON(MethodArgumentTypeMismatchException InvalidDataType){
        ErrorResponse errorbody=new ErrorResponse(
                LocalDateTime.now(),
                "Invalid Data Type used,Expecting Integer",
                null,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(errorbody,HttpStatus.BAD_REQUEST);
    }
}
