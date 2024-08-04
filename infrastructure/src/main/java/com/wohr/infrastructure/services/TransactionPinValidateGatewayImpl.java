package com.wohr.infrastructure.services;

import com.wohr.application.gateway.TransactionPinValidateGateway;
import com.wohr.core.domain.TransactionPin;
import com.wohr.infrastructure.repositories.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private final TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {

        return transactionPinEntityRepository.findById(transactionPin.getId())
                .map(savedPin -> Objects.equals(savedPin.getPin(), transactionPin.getPin()))
                .orElse(false);
    }
}