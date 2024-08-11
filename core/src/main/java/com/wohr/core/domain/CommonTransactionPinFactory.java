package com.wohr.core.domain;

import com.wohr.core.exception.TransactionPinException;

import java.time.LocalDateTime;

public class CommonTransactionPinFactory implements TransactionPinFactory {

    @Override
    public TransactionPin create(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updateAt) {
        return new CommonTransactionPin(id, pin, attempt, blocked, createdAt, updateAt);
    }

    @Override
    public TransactionPin create(String pin) throws TransactionPinException {
        return new CommonTransactionPin(pin);
    }

    @Override
    public TransactionPin create() {
        return new CommonTransactionPin();
    }
}
