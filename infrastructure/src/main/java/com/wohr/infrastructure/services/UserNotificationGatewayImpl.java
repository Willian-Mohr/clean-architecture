package com.wohr.infrastructure.services;

import com.wohr.application.gateway.UserNotificationGateway;
import com.wohr.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {

    @Override
    public Boolean notify(Transaction transaction, String email) {
        //TODO: implement
        return true;
    }
}
