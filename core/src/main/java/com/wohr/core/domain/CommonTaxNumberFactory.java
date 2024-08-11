package com.wohr.core.domain;

public class CommonTaxNumberFactory implements TaxNumberFactory {

    @Override
    public TaxNumber create(String value) throws Exception {
        return new CommonTaxNumber(value);
    }

    @Override
    public TaxNumber create() {
        return new CommonTaxNumber();
    }
}
