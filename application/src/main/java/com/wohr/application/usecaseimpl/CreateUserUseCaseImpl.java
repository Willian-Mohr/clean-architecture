package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateUserGateway;
import com.wohr.core.domain.TransactionPin;
import com.wohr.core.domain.User;
import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.InternalServerErrorException;
import com.wohr.core.exception.TaxNumberException;
import com.wohr.core.exception.TransactionPinException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.CreateUserUseCase;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, TransactionPinException, InternalServerErrorException {

        if (!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }
}
