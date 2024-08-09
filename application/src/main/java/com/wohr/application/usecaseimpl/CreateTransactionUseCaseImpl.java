package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateTransactionGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.TransferException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.CreateTransactionUseCase;

import java.math.BigDecimal;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Wallet fromWallet, Wallet toWallet, BigDecimal value) throws Exception {

        var transaction = new Transaction(fromWallet, toWallet, value);

        var transactionSaved = createTransactionGateway.create(transaction);

        if (transactionSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
