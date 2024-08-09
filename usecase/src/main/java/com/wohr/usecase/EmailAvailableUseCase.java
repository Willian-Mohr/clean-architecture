package com.wohr.usecase;

import com.wohr.core.exception.TaxNumberException;

public interface EmailAvailableUseCase {

    Boolean emailAvailable(String email) throws TaxNumberException;

}
