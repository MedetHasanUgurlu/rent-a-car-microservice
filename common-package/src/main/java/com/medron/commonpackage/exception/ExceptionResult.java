package com.medron.commonpackage.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResult<T> {
    private String type;
    private T message;
    private LocalDateTime localDateTime;

    public ExceptionResult(String type,T message){
        this.type = type;
        this.message = message;
    }

}
