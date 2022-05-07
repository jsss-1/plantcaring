package com.acat.service.ex;
/**
 * 没有Conditions的异常
 */

public class NotHaveConditionsException extends ServiceException{
    public NotHaveConditionsException() {
        super();
    }

    public NotHaveConditionsException(String message) {
        super(message);
    }

    public NotHaveConditionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotHaveConditionsException(Throwable cause) {
        super(cause);
    }

    protected NotHaveConditionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
