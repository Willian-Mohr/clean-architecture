package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notify(Transaction transaction, String email);
}