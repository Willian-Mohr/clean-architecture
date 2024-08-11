package com.wohr.core.domain;

import com.wohr.core.exception.TransactionPinException;

import java.time.LocalDateTime;

public interface TransactionPinFactory {

    TransactionPin create(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updateAt);

    TransactionPin create(String pin) throws TransactionPinException;

    TransactionPin create();
}