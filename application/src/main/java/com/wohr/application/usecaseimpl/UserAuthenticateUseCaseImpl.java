package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.UserAuthenticateGateway;
import com.wohr.entities.exception.AuthenticateException;
import com.wohr.entities.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {

        if (!userAuthenticateGateway.authenticate(username, password)){
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
