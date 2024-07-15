package com.wohr.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Invalid Tax Number", "ON-0001"),
    ON0002("Tax number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-0003"),
    ON0004("Error creating a user", "ON-0004"),
    TR0001("Shopkeeper does not have an active transfer function", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),
    TR0003("Error when trying to make a transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),
    TRP0001("Invalid PIN", "TRP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    NO0001("Error notifying user", "NO-0001"),
    ATH0001("Unauthenticated user", "ATH-0001")
    ;

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
