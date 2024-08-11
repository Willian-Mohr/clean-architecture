package com.wohr.core.domain;

public interface TaxNumberFactory {

    TaxNumber create(String value) throws Exception;

    TaxNumber create();
}
