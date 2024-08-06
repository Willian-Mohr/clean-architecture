package com.wohr.application.usecaseimpl;

import com.wohr.usecase.ConsultBalanceUseCase;
import com.wohr.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
