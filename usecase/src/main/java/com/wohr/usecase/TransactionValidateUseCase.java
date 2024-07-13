package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction);
}
