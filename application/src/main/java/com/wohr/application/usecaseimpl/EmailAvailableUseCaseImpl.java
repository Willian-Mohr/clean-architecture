package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.EmailAvailableGateway;
import com.wohr.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
