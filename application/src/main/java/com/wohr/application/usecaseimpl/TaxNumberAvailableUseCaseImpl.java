package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TaxNumberAvailableGateway;
import com.wohr.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
