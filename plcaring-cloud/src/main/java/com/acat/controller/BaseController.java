package com.acat.controller;

import com.acat.controller.ex.*;
import com.acat.service.ex.*;
import com.acat.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

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
        Result<Void> result = new Result<Void>();
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
        }if(e instanceof UsernameDuplicateException){
            result.setState(6000);
            result.setMessage("用户名被占用产生的异常");
        }else if (e instanceof InsertException){
            result.setState(7000);
            result.setMessage("注册时产生未知异常");
        }else if (e instanceof UserNotFoundException){
            result.setState(7001);
            result.setMessage("用户数据不存在的异常");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(7002);
            result.setMessage("用户名或密码错误的异常");
        }else if(e instanceof UpdateException){
            result.setState(7003);
            result.setMessage("用户数据更新时产生未知异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(8000);
            result.setMessage("文件为空的异常");
        } else if (e instanceof FileSizeException) {
            result.setState(8001);
            result.setMessage("文件大小产生异常");
        } else if (e instanceof FileTypeException) {
            result.setState(8002);
            result.setMessage("文件格式产生的异常");
        } else if (e instanceof FileStateException) {
            result.setState(8003);
            result.setMessage("文件状态产生异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(8004);
            result.setMessage("文件传输中产生异常");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session
     * @return当前登陆对象的uid
     */
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前用户的username
     * @param session
     * @return当前用户的username
     */
    protected final String getUsernameFromSession(HttpSession session){
        return String.valueOf(session.getAttribute("username").toString());
    }
}
