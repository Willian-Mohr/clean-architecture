package com.wohr.usecase;

import com.wohr.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notify(Transaction transaction, String email);
}