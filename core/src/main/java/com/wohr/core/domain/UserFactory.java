package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public interface UserFactory {

    User create(UUID id, String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, LocalDateTime createdAt, LocalDateTime updateAt);

    User create(String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type);

    User create();
}
