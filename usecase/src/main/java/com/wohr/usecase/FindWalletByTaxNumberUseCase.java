package com.wohr.usecase;

import com.wohr.entities.domain.User;
import com.wohr.entities.domain.Wallet;
import com.wohr.entities.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String taxNumber) throws NotFoundException;
}
