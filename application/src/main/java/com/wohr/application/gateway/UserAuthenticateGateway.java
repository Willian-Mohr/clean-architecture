package com.wohr.application.gateway;

public interface UserAuthenticateGateway {

    Boolean authenticate(String username, String password);
}
