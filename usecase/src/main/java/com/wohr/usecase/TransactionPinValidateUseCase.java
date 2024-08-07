package com.wohr.usecase;

import com.wohr.core.domain.TransactionPin;
import com.wohr.core.exception.PinException;

public interface TransactionPinValidateUseCase {

    Boolean validate(TransactionPin transactionPin, String pin) throws PinException;
}
