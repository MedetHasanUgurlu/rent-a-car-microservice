package com.medron.inventoryservice.exception;

import com.medron.inventoryservice.constant.ExceptionType;
import com.medron.inventoryservice.exception.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResult<Object> handleBusinessException(BusinessException exception){
        return new ExceptionResult<>(exception.getMessage(), ExceptionType.Exception.Business);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult<Object> handleBusinessException(IllegalArgumentException exception){
        return new ExceptionResult<>(exception.getMessage(), ExceptionType.Exception.Business);
    }
}
