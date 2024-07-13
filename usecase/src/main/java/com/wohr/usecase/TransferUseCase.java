package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction);
}
