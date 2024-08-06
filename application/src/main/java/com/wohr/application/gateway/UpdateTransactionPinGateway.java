package com.wohr.application.gateway;

import com.wohr.core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {

    TransactionPin update(TransactionPin transactionPin);
}
