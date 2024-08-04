package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.FindWalletByTaxNumberGateway;
import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.NotFoundException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {

        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet;
    }
}
