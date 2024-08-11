package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;
import com.wohr.core.exception.TransferException;
import com.wohr.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CommonWallet implements Wallet {

    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public CommonWallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CommonWallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public CommonWallet() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public void receiveValue(BigDecimal value) {
        this.balance.add(value);
    }

    @Override
    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if (this.balance.compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance = this.balance.subtract(value);
    }

    @Override
    public void receiveTransfer(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getUpdateAt() {
        return this.updateAt;
    }

    @Override
    public TransactionPin getTransactionPin() {
        return this.transactionPin;
    }
}
