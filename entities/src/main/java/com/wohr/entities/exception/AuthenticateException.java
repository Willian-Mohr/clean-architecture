package com.wohr.entities.exception;

public class AuthenticateException extends Exception {

    private String code;

    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }
}
