package com.example.first.microservice.advice;

import com.example.first.microservice.exception.RoleNotFoundException;
import com.example.first.microservice.exception.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex){
        ProblemDetail response;
        if(ex instanceof UserNotFoundException){
            response = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ex.getMessage());
        }else if(ex instanceof MethodArgumentNotValidException){
            List<String> errors = ((MethodArgumentNotValidException) ex).getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }else if(ex instanceof DataIntegrityViolationException){
            String message = ex.getMessage();
            if(message.contains("Duplicate entry") && message.contains("uq_email")){
                message = "Email is already exists !!";
            }
            response = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,message);
        }else if(ex instanceof RoleNotFoundException){
            response = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        }else{
            response = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
//            ex.printStackTrace();
        }
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
