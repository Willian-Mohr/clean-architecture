package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public interface User {

    UUID getId();

    String getEmail();

    String getPassword();

    String getFullName();

    TaxNumber getTaxNumber();

    UserTypeEnum getType();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdateAt();
}
