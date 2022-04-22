package com.acat.exception;

/**
 * exceptions包内封装业务的异常
 */
public class ShopOperationException extends RuntimeException  {

    private static final long serialVersionUID = -837965898242509580L;

    public ShopOperationException(String msg){
        super(msg);
    }

}
