package com.wohr.usecase;

import com.wohr.entities.domain.User;
import com.wohr.entities.exception.TaxNumberException;
import com.wohr.entities.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user,  String pin) throws TaxNumberException, TransactionPinException;
}
