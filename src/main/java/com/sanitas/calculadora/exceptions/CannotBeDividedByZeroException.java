package com.sanitas.calculadora.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CannotBeDividedByZeroException extends RuntimeException{
    public CannotBeDividedByZeroException(String message) {
        super(message);
    }
}
