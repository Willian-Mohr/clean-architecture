package com.wohr.application.gateway;

import com.wohr.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction) throws Exception;
}
