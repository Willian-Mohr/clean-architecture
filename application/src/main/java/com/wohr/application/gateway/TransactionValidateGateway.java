package com.wohr.application.gateway;

import com.wohr.entities.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);
}
