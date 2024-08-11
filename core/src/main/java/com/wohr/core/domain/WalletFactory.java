package com.wohr.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface WalletFactory {

    Wallet create(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt);

    Wallet create(TransactionPin transactionPin, BigDecimal balance, User user);

    Wallet create();
}
