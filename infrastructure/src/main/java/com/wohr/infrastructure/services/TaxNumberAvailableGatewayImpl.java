package com.wohr.infrastructure.services;

import com.wohr.application.gateway.TaxNumberAvailableGateway;
import com.wohr.infrastructure.repositories.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Start of checking whether the TaxNumber is available");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}