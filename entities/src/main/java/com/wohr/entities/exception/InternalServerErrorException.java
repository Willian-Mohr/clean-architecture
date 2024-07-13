package com.wohr.entities.exception;

public class InternalServerErrorException extends Exception {

    private String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }
}
