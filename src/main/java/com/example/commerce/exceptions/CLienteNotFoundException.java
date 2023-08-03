package com.example.commerce.exceptions;

import jakarta.validation.constraints.Positive;

public class CLienteNotFoundException extends RuntimeException {
    public CLienteNotFoundException(Long id) {
        super("Nao foi encontrado um cliente com o id " + id);
    }
}
