package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;

public interface UserNoficationUseCase {

    Boolean notify(Transaction transaction, String email);
}