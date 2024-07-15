package com.wohr.usecase;

import com.wohr.core.exception.InternalServerErrorException;
import com.wohr.core.exception.NotFoundException;
import com.wohr.core.exception.NotificationException;
import com.wohr.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException;
}
