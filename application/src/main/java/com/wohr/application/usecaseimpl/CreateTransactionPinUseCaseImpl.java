package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateTransactionPinGateway;
import com.wohr.entities.domain.TransactionPin;
import com.wohr.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private CreateTransactionPinGateway createTransactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {

        createTransactionPinGateway.create(transactionPin);

    }
}
