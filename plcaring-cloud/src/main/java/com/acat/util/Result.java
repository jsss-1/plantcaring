package com.acat.util;

import java.io.Serializable;

/**
 * 响应结果类
 * @param <E> 响应数据的类型
 */
//Serializable 空接口标志给JVM看的 让其进行序列化。
public class Result<E> implements Serializable {

    /** 状态码 */
    private Integer state;
    /** 状态描述信息 */
    private String message;
    /** 数据 */
    private E data;

    public Result() {
        super();
    }

    public Result(Integer state) {
        super();
        this.state = state;
    }

    /** 出现异常时调用 */
    public Result(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }
    public Result(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

    // Generate: Getter and Setter


    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public E getData() {
        return data;
    }

    public Integer getState() {
        return state;
    }
}
