package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateTransactionGateway;
import com.wohr.entities.domain.Transaction;
import com.wohr.entities.exception.TransferException;
import com.wohr.entities.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {

        var transactioSaved = createTransactionGateway.create(transaction);

        if (transactioSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactioSaved;
    }
}
