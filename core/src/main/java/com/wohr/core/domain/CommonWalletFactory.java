package com.wohr.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CommonWalletFactory implements WalletFactory {

    @Override
    public Wallet create(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        return new CommonWallet(id, transactionPin, balance, user, createdAt, updateAt);
    }

    @Override
    public Wallet create(TransactionPin transactionPin, BigDecimal balance, User user) {
        return new CommonWallet(transactionPin, balance, user);
    }

    @Override
    public Wallet create() {
        return new CommonWallet();
    }
}
