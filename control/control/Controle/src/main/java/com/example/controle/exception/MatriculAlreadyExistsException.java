package com.example.controle.exception;

public class MatriculAlreadyExistsException extends RuntimeException {

    public MatriculAlreadyExistsException(String message) {
        super(message);
    }

}