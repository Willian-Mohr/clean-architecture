package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.UpdateTransactionPinGateway;
import com.wohr.core.domain.TransactionPin;
import com.wohr.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {

    private final UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }


    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return updateTransactionPinGateway.update(transactionPin);
    }
}
