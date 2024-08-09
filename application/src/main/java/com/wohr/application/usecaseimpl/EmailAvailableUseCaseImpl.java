package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.EmailAvailableGateway;
import com.wohr.core.exception.TaxNumberException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) throws TaxNumberException {

        if (!emailAvailableGateway.emailAvailable(email)) {
            throw new TaxNumberException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        return true;
    }
}
