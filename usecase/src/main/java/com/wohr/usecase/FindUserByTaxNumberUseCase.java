package com.wohr.usecase;

import com.wohr.entities.domain.User;

public interface FindUserByTaxNumberUseCase {

    User findByTaxNumber(String taxNumber);
}
