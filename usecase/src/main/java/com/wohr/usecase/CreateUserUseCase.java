package com.wohr.usecase;

import com.wohr.core.domain.User;
import com.wohr.core.exception.InternalServerErrorException;
import com.wohr.core.exception.TaxNumberException;
import com.wohr.core.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user,  String pin) throws TaxNumberException, TransactionPinException, InternalServerErrorException;
}
