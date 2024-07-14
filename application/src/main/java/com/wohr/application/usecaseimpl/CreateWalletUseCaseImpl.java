package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.CreateWalletGateway;
import com.wohr.entities.domain.Wallet;
import com.wohr.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {

        createWalletGateway.create(wallet);

    }
}
