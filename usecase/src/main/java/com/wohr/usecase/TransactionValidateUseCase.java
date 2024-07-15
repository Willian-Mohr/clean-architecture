package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;
import com.wohr.entities.exception.TransferException;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction) throws TransferException;
}
