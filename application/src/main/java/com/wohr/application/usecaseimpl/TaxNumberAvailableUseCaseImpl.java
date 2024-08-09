package com.wohr.application.usecaseimpl;

import com.wohr.application.gateway.TaxNumberAvailableGateway;
import com.wohr.core.exception.TaxNumberException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException {

        if (!taxNumberAvailableGateway.taxNumberAvailable(taxNumber)) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        return true;
    }
}
