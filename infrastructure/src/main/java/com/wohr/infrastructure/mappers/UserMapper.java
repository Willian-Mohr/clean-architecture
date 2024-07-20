package com.wohr.infrastructure.mappers;

import com.wohr.core.domain.TaxNumber;
import com.wohr.core.domain.User;
import com.wohr.infrastructure.dto.requests.CreateUserRequest;
import com.wohr.infrastructure.entites.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
                request.email(),
                request.password(),
                request.fullname(),
                new TaxNumber(request.taxNumber()),
                request.type()
        );
    }
}
