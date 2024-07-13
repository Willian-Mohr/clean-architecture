package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;

public interface CreateTransactionUseCase {

    void create(Transaction transaction);
}
