package com.wohr.usecase;

import com.wohr.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(Wallet wallet);
}
