package com.wohr.infrastructure.dto.responses;

import java.util.List;

public record ErrorResponse(String code, String message, List<ValidationError> validations) {
}