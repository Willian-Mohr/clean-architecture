package com.wohr.core.domain;

import com.wohr.core.exception.TransferException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Wallet {

    Long getId();

    BigDecimal getBalance();

    void receiveValue(BigDecimal value);

    void transfer(BigDecimal value) throws TransferException;

    void receiveTransfer(BigDecimal value);

    User getUser();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdateAt();

    TransactionPin getTransactionPin();
}
