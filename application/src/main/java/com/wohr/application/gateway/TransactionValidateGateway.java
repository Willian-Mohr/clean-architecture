package com.wohr.application.gateway;

import com.wohr.core.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);
}
