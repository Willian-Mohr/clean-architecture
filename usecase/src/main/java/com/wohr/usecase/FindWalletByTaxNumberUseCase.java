package com.wohr.usecase;

import com.wohr.core.domain.Wallet;
import com.wohr.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
