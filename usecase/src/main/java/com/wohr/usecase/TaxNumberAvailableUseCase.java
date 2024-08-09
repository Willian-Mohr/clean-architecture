package com.wohr.usecase;

import com.wohr.core.exception.TaxNumberException;

public interface TaxNumberAvailableUseCase {

    Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException;
}
