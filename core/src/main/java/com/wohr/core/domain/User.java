package com.wohr.core.domain;

import com.wohr.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID id;

    private String email;
    private String password;
    private String fullName;
    private TaxNumber taxNumber;
    private UserTypeEnum type;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public User(UUID id, String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public User(String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email) && password.equals(user.password) && fullName.equals(user.fullName) && taxNumber.equals(user.taxNumber) && type == user.type && createdAt.equals(user.createdAt) && Objects.equals(updateAt, user.updateAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + taxNumber.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + Objects.hashCode(updateAt);
        return result;
    }
}
