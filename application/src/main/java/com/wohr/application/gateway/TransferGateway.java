package com.wohr.application.gateway;

import com.wohr.core.domain.Transaction;

public interface TransferGateway {

    Boolean transfer(Transaction transaction);
}
