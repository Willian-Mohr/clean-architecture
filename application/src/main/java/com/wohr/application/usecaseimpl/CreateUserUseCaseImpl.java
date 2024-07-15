package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateUserGateway;
import com.wohr.entities.domain.TransactionPin;
import com.wohr.entities.domain.User;
import com.wohr.entities.domain.Wallet;
import com.wohr.entities.exception.InternalServerErrorException;
import com.wohr.entities.exception.TaxNumberException;
import com.wohr.entities.exception.TransactionPinException;
import com.wohr.entities.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.CreateUserUseCase;
import com.wohr.usecase.EmailAvailableUseCase;
import com.wohr.usecase.TaxNumberAvailableUseCase;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, TransactionPinException, InternalServerErrorException {

        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransactionPin(user, pin))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }
}
