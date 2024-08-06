package com.wohr.infrastructure.services;

import com.wohr.application.gateway.UpdateTransactionPinGateway;
import com.wohr.core.domain.TransactionPin;
import com.wohr.infrastructure.mappers.TransactionPinMapper;
import com.wohr.infrastructure.repositories.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {

    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;

    public UpdateTransactionPinGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        var transactionPinEntity = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(transactionPin));

        return transactionPinMapper.toTransactionPin(transactionPinEntity);
    }
}
