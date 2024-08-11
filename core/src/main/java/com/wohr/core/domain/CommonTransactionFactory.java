package com.wohr.core.domain;

import com.wohr.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CommonTransactionFactory implements TransactionFactory {

    @Override
    public Transaction create(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updateAt) {
        return new CommonTransaction(id, toWallet, toWallet, value, status, createdAt, updateAt);
    }

    @Override
    public Transaction create( Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        return new CommonTransaction(fromWallet, toWallet, value);
    }

    @Override
    public Transaction create() {
        return new CommonTransaction();
    }
}
