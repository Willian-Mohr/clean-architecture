package com.wohr.core.domain;

import com.wohr.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionFactory {

    Transaction create(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updateAt);

    Transaction create(Wallet fromWallet, Wallet toWallet, BigDecimal value);

    Transaction create();
}
