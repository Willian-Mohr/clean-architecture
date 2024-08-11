package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommonUser implements User {

    private UUID id;

    private String email;
    private String password;
    private String fullName;
    private TaxNumber taxNumber;
    private UserTypeEnum type;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public CommonUser(UUID id, String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CommonUser(String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    public CommonUser() {
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public TaxNumber getTaxNumber() {
        return this.taxNumber;
    }

    @Override
    public UserTypeEnum getType() {
        return this.type;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getUpdateAt() {
        return this.updateAt;
    }
}
