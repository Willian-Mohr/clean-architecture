package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TransferGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.core.exception.InternalServerErrorException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.TransferUseCase;

public class TransferUseCaseImpl implements TransferUseCase {

    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(Transaction transaction) throws Exception {

        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
