package com.peng.sms.api;

/**
 * Encapsulates API error codes
 */
public interface IErrorCode {
    /**
     * Get the error code
     * @return error code as long
     */
    long getCode();

    /**
     * Get the error message
     * @return error message as String
     */
    String getMessage();
}
