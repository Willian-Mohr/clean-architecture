package com.wohr.usecase;

import com.wohr.core.domain.Transaction;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction) throws Exception;
}
