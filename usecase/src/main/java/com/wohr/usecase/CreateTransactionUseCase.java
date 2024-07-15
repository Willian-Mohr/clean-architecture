package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;
import com.wohr.entities.exception.TransferException;

public interface CreateTransactionUseCase {

    Transaction create(Transaction transaction) throws TransferException;
}
