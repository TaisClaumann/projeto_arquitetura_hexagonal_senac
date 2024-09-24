package com.example.arquiteturahexagonal.core.services.exceptions;

public class RegistroJaCadastradoException extends RuntimeException {

    public RegistroJaCadastradoException(String msg) {
        super(msg);
    }

    public RegistroJaCadastradoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}