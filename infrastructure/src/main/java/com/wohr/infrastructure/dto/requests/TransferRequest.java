package com.wohr.infrastructure.dto.requests;

import java.math.BigDecimal;

public record TransferRequest(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) {
}
