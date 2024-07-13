package com.wohr.entities.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Invalid Tax Number ", "ON-0001"),
    TR0001("Shopkeeper does not have an active transfer function", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),
    TRP0001("Invalid PIN", "TRP-0001");

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
