package com.wohr.core.domain;

import com.wohr.core.exception.TaxNumberException;
import com.wohr.core.exception.enums.ErrorCodeEnum;

public class CommonTaxNumber implements TaxNumber {

    private String value;

    public CommonTaxNumber(String taxNumber) throws Exception {
        setValue(taxNumber);
    }

    public CommonTaxNumber() {
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) throws TaxNumberException {
        if (!isValid(value))
            throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        this.value = value;
    }

    @Override
    public Boolean isValid(String taxNumber) throws TaxNumberException {

        if (taxNumber.replaceAll("[^0-9]", "").length() == 11 || taxNumber.replaceAll("[^0-9]", "").length() == 14) {
            if (taxNumber.length() == 11) {
                return isCpfValid(taxNumber);
            } else {
                return isCnpjValid(taxNumber);
            }
        } else {
            throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }
    }

    @Override
    public Boolean isCpfValid(String cpf) {

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        if (cpf.charAt(9) - '0' != firstDigit) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cpf.charAt(10) - '0' == secondDigit;
    }

    @Override
    public Boolean isCnpjValid(String cnpj) {
        int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights1[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights2[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cnpj.charAt(12) - '0' == secondDigit;
    }
}