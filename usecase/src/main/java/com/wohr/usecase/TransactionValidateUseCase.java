package com.wohr.usecase;

import com.wohr.core.domain.Transaction;
import com.wohr.core.exception.TransferException;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction) throws TransferException;
}
