package com.wohr.application.usecaseimpl;

import com.wohr.core.domain.TransactionPin;
import com.wohr.core.exception.PinException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.TransactionPinValidateUseCase;
import com.wohr.usecase.UpdateTransactionPinUseCase;

import java.util.Objects;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws PinException {

        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        if (!Objects.equals(transactionPin.getPin(), pin)) {
            transactionPin.setAttempt();
            updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.PIN0002.getMessage(), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3) {
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
