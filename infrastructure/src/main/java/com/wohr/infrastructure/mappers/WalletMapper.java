package com.wohr.infrastructure.mappers;

import com.wohr.core.domain.Wallet;
import com.wohr.infrastructure.entites.TransactionPinEntity;
import com.wohr.infrastructure.entites.UserEntity;
import com.wohr.infrastructure.entites.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }
}
