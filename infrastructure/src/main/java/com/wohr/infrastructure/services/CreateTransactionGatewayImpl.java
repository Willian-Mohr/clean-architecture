package com.wohr.infrastructure.services;

import com.wohr.application.gateway.CreateTransactionGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.infrastructure.mappers.TransactionMapper;
import com.wohr.infrastructure.repositories.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {

        try {
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            return null;
        }
    }
}
