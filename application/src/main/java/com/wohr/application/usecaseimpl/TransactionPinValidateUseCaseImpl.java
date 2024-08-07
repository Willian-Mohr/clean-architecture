package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TransactionPinValidateGateway;
import com.wohr.core.domain.TransactionPin;
import com.wohr.core.exception.PinException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.TransactionPinValidateUseCase;
import com.wohr.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;

    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws PinException {

        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        if (!transactionPinValidateGateway.validate(transactionPin, pin)) {
            transactionPin.setAttempt();
            updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.PIN0002.getMessage(), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() > 3) {
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
