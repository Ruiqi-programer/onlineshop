package com.peng.sms.exception;

import com.peng.sms.api.IErrorCode;
import lombok.Getter;

/**
 * Custom API exception
 */
@Getter
public class ApiException extends RuntimeException {
    /**
     * Error code associated with this exception
     */
    private IErrorCode errorCode;

    /**
     * Constructor with error code
     *
     * @param errorCode the error code
     */
    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * Constructor with custom message
     *
     * @param message the exception message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * Constructor with cause
     *
     * @param cause the throwable cause
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with message and cause
     *
     * @param message the exception message
     * @param cause   the throwable cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
