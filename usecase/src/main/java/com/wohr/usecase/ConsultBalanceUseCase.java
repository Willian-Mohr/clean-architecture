package com.wohr.usecase;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(String taxNumber) throws Exception;
}
