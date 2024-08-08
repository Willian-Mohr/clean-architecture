package com.wohr.infrastructure.mappers;

import com.wohr.core.domain.Wallet;
import com.wohr.infrastructure.entites.TransactionPinEntity;
import com.wohr.infrastructure.entites.UserEntity;
import com.wohr.infrastructure.entites.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    private final TransactionPinMapper transactionPinMapper;
    private final UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {

        if (walletEntity == null){
            return null;
        }
        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                userMapper.toUser(walletEntity.getUserEntity()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdatedAt()
        );
    }

    public WalletEntity toWalletEntity(Wallet wallet) {
        return new WalletEntity(
                wallet.getBalance(),
                userMapper.toUserEntity(wallet.getUser()),
                transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }
}
