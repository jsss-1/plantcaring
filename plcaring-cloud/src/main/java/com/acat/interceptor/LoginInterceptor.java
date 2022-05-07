package com.acat.interceptor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 定义一个拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 检测全局session中是否有uid，没有则返回到登陆页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器（url+Controller：映射）
     * @return true false
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //HttpServletRequest对象获得Session
//        Object obj = request.getSession().getAttribute("uid");
//        if(obj == null){
//            //说明用户没有登录过系统，则重新向到login.html页面
//            response.sendRedirect("/web/login.html");
//            //结束后续调用
//            return false;
//        }
//        //请求放行
//        return true;
    /**
     * RedisTemplate<String,Object> 已经提前注入
     */
        RedisTemplate<String,Object> redisTemplate = RedisUtils.redisTemplate;
        //从headers中获得token
        String token = request.getHeader("token");
        //如果token为空则赋予空字符串
        token = token == null ? "" : token;
        //查询Redis中的时间
//        Long expire = redisTemplate.getExpire(token);
        Long expire = redisTemplate.getExpire(token);
        if(expire < 0 ){
            //说明用户没有登录过系统，则重新向到login.html页面
            response.sendRedirect("返回登录界面");
            //结束后续调用
            return false;
        }

        //重置时间为30min
        redisTemplate.expire(token,30L, TimeUnit.MINUTES);
        //        请求放行
        return true;
    }
}
