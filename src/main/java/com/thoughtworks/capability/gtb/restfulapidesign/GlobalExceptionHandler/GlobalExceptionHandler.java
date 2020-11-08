package com.thoughtworks.capability.gtb.restfulapidesign.GlobalExceptionHandler;

import com.thoughtworks.capability.gtb.restfulapidesign.Error.ResultError;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.StudentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ResultError> handler(StudentException ex) {
        ResultError resultError = ResultError.builder().errorCode("400").errorMessage(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(resultError);
    }
}
