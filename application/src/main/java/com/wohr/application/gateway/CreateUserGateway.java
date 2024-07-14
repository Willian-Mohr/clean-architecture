package com.wohr.application.gateway;

import com.wohr.entities.domain.User;

public interface CreateUserGateway {

    User create(User user);
}
