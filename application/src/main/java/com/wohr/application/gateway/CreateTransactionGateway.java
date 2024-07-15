package com.wohr.application.gateway;

import com.wohr.entities.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
