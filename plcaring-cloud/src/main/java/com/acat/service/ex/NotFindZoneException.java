package com.acat.service.ex;
/**找不到指定灌溉区的异常*/
public class NotFindZoneException extends ServiceException{
    public NotFindZoneException() {
        super();
    }

    public NotFindZoneException(String message) {
        super(message);
    }

    public NotFindZoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFindZoneException(Throwable cause) {
        super(cause);
    }

    protected NotFindZoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
