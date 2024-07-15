package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.ConsultBalanceGateway;
import com.wohr.core.domain.Wallet;
import com.wohr.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
