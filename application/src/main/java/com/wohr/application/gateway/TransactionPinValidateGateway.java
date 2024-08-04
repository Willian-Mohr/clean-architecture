package com.wohr.application.gateway;

import com.wohr.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {

    Boolean validate(TransactionPin transactionPin);
}
