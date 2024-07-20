package com.wohr.infrastructure.dto.responses;

public record ValidationError(String field, String message) {
}