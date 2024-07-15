package com.wohr.usecase;

import com.wohr.entities.domain.Transaction;
import com.wohr.entities.exception.InternalServerErrorException;
import com.wohr.entities.exception.NotFoundException;
import com.wohr.entities.exception.NotificationException;
import com.wohr.entities.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException;
}
