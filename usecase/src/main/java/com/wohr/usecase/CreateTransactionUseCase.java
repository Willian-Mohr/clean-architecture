package com.wohr.usecase;

import com.wohr.core.domain.Transaction;
import com.wohr.core.exception.TransferException;

public interface CreateTransactionUseCase {

    Transaction create(Transaction transaction) throws TransferException;
}
