package com.wohr.infrastructure.services;

import com.wohr.application.gateway.TransactionValidateGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.infrastructure.clients.ApiValidateService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {

        var response = apiValidateService.validate();

        if (response == null) {
            return false;
        }

        return response.success();
    }
}
