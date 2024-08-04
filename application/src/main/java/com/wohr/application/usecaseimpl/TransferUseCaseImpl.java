package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TransferUseCaseGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.*;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferUseCaseGateway transferUseCaseGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferUseCaseGateway transferUseCaseGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferUseCaseGateway = transferUseCaseGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception {

        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferUseCaseGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notify(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
