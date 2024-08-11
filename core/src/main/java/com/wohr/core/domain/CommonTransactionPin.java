package com.wohr.core.domain;

import com.wohr.core.exception.TransactionPinException;
import com.wohr.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class CommonTransactionPin implements TransactionPin {

    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public CommonTransactionPin(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CommonTransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public CommonTransactionPin() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getPin() {
        return this.pin;
    }

    @Override
    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    @Override
    public void pinIsValid(String pin) throws TransactionPinException {
        if (pin.isBlank() && pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    @Override
    public Integer getAttempt() {
        return this.attempt;
    }

    @Override
    public void setAttempt() {
        if (this.attempt == 1) {
            this.blocked = true;
            this.attempt = 0;
        } else {
            this.attempt = this.attempt - 1;
        }
    }

    @Override
    public void restoreAttempt() {
        this.attempt = 3;
    }

    @Override
    public Boolean getBlocked() {
        return this.blocked;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getUpdateAt() {
        return this.updateAt;
    }
}
