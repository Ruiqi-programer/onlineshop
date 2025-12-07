package com.peng.sms.api;

import lombok.Getter;

/**
 * Enum for some common API operation codes
 */
@Getter
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Operation successful"),
    FAILED(500, "Operation failed"),
    VALIDATE_FAILED(404, "Parameter validation failed"),
    UNAUTHORIZED(401, "Not logged in or token has expired"),
    FORBIDDEN(403, "No relevant permissions");

    private final long code;
    private final String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
