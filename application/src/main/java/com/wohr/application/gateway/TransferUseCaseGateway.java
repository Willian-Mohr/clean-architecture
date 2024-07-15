package com.wohr.application.gateway;

import com.wohr.entities.domain.Transaction;

public interface TransferUseCaseGateway {

    Boolean transfer(Transaction transaction);
}
