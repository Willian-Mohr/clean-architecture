package com.wohr.application.gateway;

import com.wohr.entities.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);
}
