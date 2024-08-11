package com.wohr.core.domain;

import com.wohr.core.exception.TransactionPinException;

import java.time.LocalDateTime;

public interface TransactionPin {

    Long getId();

    String getPin();

    void setPin(String pin) throws TransactionPinException;

    void pinIsValid(String pin) throws TransactionPinException;

    Integer getAttempt();

    void setAttempt();

    void restoreAttempt();

    Boolean getBlocked();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdateAt();
}
