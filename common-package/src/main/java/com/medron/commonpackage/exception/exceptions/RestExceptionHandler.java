package com.medron.commonpackage.exception.exceptions;

import com.medron.commonpackage.constant.ExceptionType;
import com.medron.commonpackage.exception.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResult<Object> handleBusinessException(BusinessException exception){
        return new ExceptionResult<>(ExceptionType.Business,exception.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult<Object> handleBusinessException(IllegalArgumentException exception){
        return new ExceptionResult<>(ExceptionType.Business,exception.getMessage());
    }

}
