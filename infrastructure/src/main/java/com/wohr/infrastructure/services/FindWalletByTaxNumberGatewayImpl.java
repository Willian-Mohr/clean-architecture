package com.wohr.infrastructure.services;

import com.wohr.application.gateway.FindWalletByTaxNumberGateway;
import com.wohr.core.domain.Wallet;
import com.wohr.infrastructure.mappers.WalletMapper;
import com.wohr.infrastructure.repositories.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
