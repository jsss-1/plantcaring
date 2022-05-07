package com.acat.service.ex;

/**
 * 查找不到Conditions的异常
 */
public class NotFindConditions extends ServiceException{
    public NotFindConditions() {
        super();
    }

    public NotFindConditions(String message) {
        super(message);
    }

    public NotFindConditions(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFindConditions(Throwable cause) {
        super(cause);
    }

    protected NotFindConditions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
