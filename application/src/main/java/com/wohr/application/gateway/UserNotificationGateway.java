package com.wohr.application.gateway;

import com.wohr.core.domain.Transaction;

public interface UserNotificationGateway {

    Boolean notify(Transaction transaction, String email);
}
