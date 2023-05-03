package com.medron.inventoryservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResult<T> {
    private T message;
    private String type;
    LocalDateTime localDateTime;
    public ExceptionResult(T message,String type){
        this.message = message;
        this.type = type;
        localDateTime = LocalDateTime.now();
    }
}
