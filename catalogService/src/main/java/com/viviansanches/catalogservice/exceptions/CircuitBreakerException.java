package com.viviansanches.catalogservice.exceptions;

public class CircuitBreakerException extends Exception{

    public CircuitBreakerException(String message) {
        super(message);
    }
}
