package com.wohr.application.gateway;

import com.wohr.entities.domain.TransactionPin;
import com.wohr.entities.domain.User;
import com.wohr.entities.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);
}
