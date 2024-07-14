package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateUserGateway;
import com.wohr.entities.domain.TransactionPin;
import com.wohr.entities.domain.User;
import com.wohr.entities.domain.Wallet;
import com.wohr.entities.exception.TaxNumberException;
import com.wohr.entities.exception.TransactionPinException;
import com.wohr.entities.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;
    private CreateWalletUseCase createWalletUseCase;
    private CreateTransactionPinUseCase createTransactoionPinUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway, CreateWalletUseCase createWalletUseCase, CreateTransactionPinUseCase createTransactoionPinUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactoionPinUseCase = createTransactoionPinUseCase;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, TransactionPinException {

        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var userSaved = createUserGateway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, userSaved));
        createTransactoionPinUseCase.create(new TransactionPin(userSaved, pin));

    }
}
