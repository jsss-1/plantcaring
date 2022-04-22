package com.acat.service.ex;
/**没有灌溉区的异常*/
public class NotHaveZoneException extends ServiceException{
    public NotHaveZoneException() {
        super();
    }

    public NotHaveZoneException(String message) {
        super(message);
    }

    public NotHaveZoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotHaveZoneException(Throwable cause) {
        super(cause);
    }

    protected NotHaveZoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
