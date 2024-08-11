package com.wohr.core.domain;

import com.wohr.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Transaction {

    Long getId();

    Wallet getFromWallet();

    Wallet getToWallet();

    BigDecimal getValue();

    TransactionStatusEnum getStatus();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdateAt();

}