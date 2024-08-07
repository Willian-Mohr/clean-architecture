package com.wohr.infrastructure.services;

import com.wohr.application.gateway.TransferGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.infrastructure.mappers.TransactionMapper;
import com.wohr.infrastructure.mappers.WalletMapper;
import com.wohr.infrastructure.repositories.TransactionEntityRepository;
import com.wohr.infrastructure.repositories.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferGatewayImpl implements TransferGateway {

    private final WalletEntityRepository walletEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;
    private final WalletMapper walletMapper;
    private final TransactionMapper transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getToWallet()));
            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        } catch (Exception e) {
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
    }
}
