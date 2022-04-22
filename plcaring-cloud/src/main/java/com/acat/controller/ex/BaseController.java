package com.acat.controller.ex;

import com.acat.service.ex.*;
import com.acat.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层的基类
 */
public class BaseController {
    /**操作成功状态码*/
    public static final int OK = 200;
    //请求处理方法。这个方法的返回值就是需要传递给前端的对象
    //自动将异常对象传递给方法的参数列表上
    //@ExceptionHandler：当前项目中产生异常，被统一拦截到此方法中，这个方法此时就充当请求处理方法。方法返回值直接给到前端
    @ExceptionHandler({ServiceException.class}) //用于统一处理抛出异常
    public Result<Void> handleException(Throwable e){
        Result<Void> result = new Result<>();
        if(e instanceof NotHaveConditionsException){
            result.setState(4000);
            result.setMessage("没有植物情况的异常");
        }else if(e instanceof NotFindConditions){
            result.setState(4001);
            result.setMessage("没有指定植物的异常");
        }else if(e instanceof NotHaveZoneException){
            result.setState(4003);
            result.setMessage("没有灌溉区的异常");
        }else if(e instanceof NotFindZoneException){
            result.setState(4004);
            result.setMessage("没有指定灌溉区的异常");
        }else if(e instanceof InsertException){
            result.setState(5001);
            result.setMessage("插入产生的异常");
        }else if(e instanceof UpdateException){
            result.setState(5002);
            result.setMessage("修改产生的异常");
        }
        return result;
    }
}
