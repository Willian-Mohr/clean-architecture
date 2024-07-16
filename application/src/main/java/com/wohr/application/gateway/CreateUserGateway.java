package com.wohr.application.gateway;

import com.wohr.core.domain.User;
import com.wohr.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);
}
