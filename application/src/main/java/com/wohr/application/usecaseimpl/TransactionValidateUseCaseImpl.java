package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TransactionValidateGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.core.exception.TransferException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {

        if (!transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
