package com.wohr.infrastructure.dto.requests;

import com.wohr.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin) {
}
