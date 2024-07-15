package com.wohr.usecase;

import com.wohr.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {

    Boolean authenticate(String username, String password) throws AuthenticateException;
}
