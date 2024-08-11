package com.wohr.core.domain;

import com.wohr.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CommonTransaction implements Transaction {

    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public CommonTransaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CommonTransaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public CommonTransaction() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Wallet getFromWallet() {
        return this.fromWallet;
    }

    @Override
    public Wallet getToWallet() {
        return this.toWallet;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public TransactionStatusEnum getStatus() {
        return this.status;
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
