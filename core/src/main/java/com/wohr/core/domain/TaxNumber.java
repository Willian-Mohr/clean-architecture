package com.wohr.core.domain;

import com.wohr.core.exception.TaxNumberException;

public interface TaxNumber {

    String getValue();

    void setValue(String value) throws TaxNumberException;

    Boolean isValid(String taxNumber) throws TaxNumberException;

    Boolean isCpfValid(String cpf);

    Boolean isCnpjValid(String cnpj);
}
