package com.wohr.infrastructure.configurations;

import com.wohr.application.gateway.CreateUserGateway;
import com.wohr.application.gateway.EmailAvailableGateway;
import com.wohr.application.gateway.TaxNumberAvailableGateway;
import com.wohr.application.usecaseimpl.CreateUserUseCaseImpl;
import com.wohr.application.usecaseimpl.EmailAvailableUseCaseImpl;
import com.wohr.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import com.wohr.usecase.CreateUserUseCase;
import com.wohr.usecase.EmailAvailableUseCase;
import com.wohr.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}