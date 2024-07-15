package com.wohr.application.gateway;

import com.wohr.core.domain.Transaction;

public interface TransferUseCaseGateway {

    Boolean transfer(Transaction transaction);
}
