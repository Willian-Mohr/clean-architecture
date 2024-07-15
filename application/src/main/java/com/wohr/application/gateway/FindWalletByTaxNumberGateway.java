package com.wohr.application.gateway;

import com.wohr.entities.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber);
}
