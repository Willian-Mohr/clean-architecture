package com.wohr.infrastructure.services;

import com.wohr.application.gateway.TransactionPinValidateGateway;
import com.wohr.core.domain.TransactionPin;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) {
        return Objects.equals(transactionPin.getPin(), pin);
    }
}