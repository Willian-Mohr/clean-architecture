package com.wohr.application.gateway;

import com.wohr.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
