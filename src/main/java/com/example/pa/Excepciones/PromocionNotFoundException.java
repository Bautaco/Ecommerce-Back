package com.example.pa.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PromocionNotFoundException extends RuntimeException {
    public PromocionNotFoundException(String message) {
        super(message);
    }
}

