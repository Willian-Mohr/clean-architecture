package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(UUID id, String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, LocalDateTime createdAt, LocalDateTime updateAt) {
        return new CommonUser(id, email, password, fullName, taxNumber, type, createdAt, updateAt);
    }

    @Override
    public User create(String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type) {
        return new CommonUser(email, password, fullName, taxNumber, type);
    }

    @Override
    public User create() {
        return new CommonUser();
    }
}
