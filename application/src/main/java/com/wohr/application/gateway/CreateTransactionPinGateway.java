package com.wohr.application.gateway;

import com.wohr.entities.domain.TransactionPin;

public interface CreateTransactionPinGateway {

    void create(TransactionPin transactionPin);
}
