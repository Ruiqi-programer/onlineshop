package com.peng.sms.exception;

import com.peng.sms.api.IErrorCode;

/**
 * Assertion utility class for throwing various API exceptions
 */
public class Asserts {
    /**
     * Throw an API exception with a custom message
     * @param message the exception message
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * Throw an API exception with a specific error code
     *
     * @param errorCode the error code
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
