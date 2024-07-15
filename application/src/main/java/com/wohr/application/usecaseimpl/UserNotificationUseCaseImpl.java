package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.UserNotificationGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notify(Transaction transaction, String email) {
        return userNotificationGateway.notify(transaction, email);
    }
}
