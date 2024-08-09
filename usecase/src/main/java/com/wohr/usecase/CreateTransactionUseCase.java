package com.wohr.usecase;

import com.wohr.core.domain.Transaction;
import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {

    Transaction create(Wallet fromWallet, Wallet toWallet, BigDecimal value) throws Exception;
}
