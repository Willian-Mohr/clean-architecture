package com.wohr.infrastructure.services;

import com.wohr.application.gateway.EmailAvailableGateway;
import com.wohr.infrastructure.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {

    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}