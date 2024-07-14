package com.wohr.entities.exception;

public class EmailException extends Exception {

    private String code;

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }
}
