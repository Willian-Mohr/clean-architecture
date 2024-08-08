package com.wohr.infrastructure.mappers;

import com.wohr.core.domain.Transaction;
import com.wohr.core.domain.TransactionStatusEnum;
import com.wohr.infrastructure.entites.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private final WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getCreatedAt()

        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }
}
