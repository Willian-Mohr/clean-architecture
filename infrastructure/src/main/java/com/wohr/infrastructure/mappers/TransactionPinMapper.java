package com.wohr.infrastructure.mappers;

import com.wohr.core.domain.TransactionPin;
import com.wohr.infrastructure.entites.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdateAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity) {

        return new TransactionPin(
                transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getCreatedAt()
        );
    }
}
