package com.wohr.infrastructure.services;

import com.wohr.application.gateway.CreateUserGateway;
import com.wohr.core.domain.User;
import com.wohr.core.domain.Wallet;
import com.wohr.infrastructure.mappers.TransactionPinMapper;
import com.wohr.infrastructure.mappers.UserMapper;
import com.wohr.infrastructure.mappers.WalletMapper;
import com.wohr.infrastructure.repositories.TransactionPinEntityRepository;
import com.wohr.infrastructure.repositories.UserEntityRepository;
import com.wohr.infrastructure.repositories.WalletEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try {
            log.info("Start of user creation::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("User created successfully::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.error("There was an error creating the user::CreateUserGatewayImpl");
            return false;
        }
    }
}
