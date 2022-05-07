package com.acat.controller;


import com.acat.controller.ex.*;
import com.acat.dao.pojo.User;
import com.acat.service.UserService;
import com.acat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController//@Controller+@ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;


//    @RequestMapping("reg")
//    //@RseponseBode//表示此方法以Jason格式进行数据相应给到前端
//    public JsonResult<Void> reg(User user){
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult();
//        try{
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        }catch (UsernameDuplicatedException e){
//            result.setState(4000);
//            result.setMessage("用户名已经被占用");
//        }catch (InsertException e){
//            result.setState(5000);
//            result.setMessage("注册时产生未知异常");
//        }
//        return result;
//    }


    @RequestMapping("reg")
    //@RseponseBode//表示此方法以Jason格式进行数据相应给到前端
    public Result<Void> reg(User user){
        userService.reg(user);
        return new Result<>(OK);
    }


    @RequestMapping("login")
    public Result<String> login(String username, String password){
        User date = userService.login(username, password);
//        向session对象中完成数据的绑定
//        session.setAttribute("uid", date.getUid());
//        session.setAttribute("username", date.getUsername());

        /**生成token令牌 UUID.randomUUID()+"":随机生成字符串*/
        String token = UUID.randomUUID()+"";
        redisTemplate.opsForValue().set(token,date, Duration.ofMinutes(30L));
        /**返回token给前端记得改！！！！*/
        return new Result<String>(OK, token);

//        return new JsonResult<User>(OK , date);
    }

    @RequestMapping("change_password")
    public Result<Void> changePassword(String oldPassword, String newPassword, HttpServletRequest request){
        //从headers中获得token
        String token = request.getHeader("token");
        //从Redis中取得对应的User
        User date = (User) redisTemplate.opsForValue().get(token);
        //获取uid
        Integer uid = date.getUid();
        userService.changePassword(uid, oldPassword, newPassword);

        //更改密码后应该退出重新登陆
        //所以将token的时间设为0，由拦截器拦截返回登录页面
        redisTemplate.expire(token,0L, TimeUnit.MINUTES);
        //删除redis中的数据
        redisTemplate.delete(token);

        return new Result<>(OK);
    }


    @RequestMapping("get_by_uid")
    public Result<User> getByUid(HttpServletRequest request){
        //从headers中获得token
        String token = request.getHeader("token");
        User date = (User) redisTemplate.opsForValue().get(token);
        //获取uid
        Integer uid = date.getUid();
        User newDate = userService.getByUid(uid);

        return new Result<User>(OK,newDate);
    }

    @RequestMapping("change_info")
    public Result<Void> changeInfo(HttpServletRequest request,User user){
        //user对象中有表单提交信息
//        Integer uid = getuidFromSession(session);
//        String username = getUsernameFromSession(session);

        //从headers中获得token
        String token = request.getHeader("token");
        User date = (User) redisTemplate.opsForValue().get(token);
        //获取uid
        Integer uid = date.getUid();
        //获取username
        String username = date.getUsername();

        userService.changeInfo(uid, username, user);

        return new Result<>(OK);
    }

    /**设置文件传输的最大值*/
    public static final int AVATAR_MAX_SIZE = 10*1024*1024;
    /**限制文件上传类型*/
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("images/jpeg");
        AVATAR_TYPE.add("images/png");
        AVATAR_TYPE.add("images/bmg");
        AVATAR_TYPE.add("images/gif");
    }
    /***
     * MultipartFile接口时SpringMVC提供的2，这个接口为我们包装了获取文件类型的数据（任何类型的file都可以接收）
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("change_avatar")
    public Result<String> changeAvatar(HttpSession session, MultipartFile file){
        //判断文件是否为空
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        //判断文件大小
        if(file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件大小超出限制");
        }
        //判断文件类型
        String contentType = file.getContentType();
        //如果包含返回true
        if(!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型不支持");
        }
        //上传的文件: .../upload/文件.png
        String parent = session.getServletContext().getRealPath("upload");
        //File对象指向这个路径,file是否存在
        File dir = new File(parent);
        if(!dir.exists()){//判断目录是否存在
            dir.mkdirs();//不存在创建目录
        }
        //获取到这个文件的名称，UUID工具来生成一个新的字符串作为文件名
        //例如：avatar001.png
        String originaFikename = file.getOriginalFilename();
        int index = originaFikename.lastIndexOf(".");//获取“.”的未知
        String suffix = originaFikename.substring(index);//从“.”处进行分割
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        //是一个空文件
        File dest = new File(dir,filename);
        //参数file中数据写入这个空文件中
        try{
            file.transferTo(dest);
        }catch (IOException e){
            throw new FileUploadIOException("文件读写异常");
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }

        Integer uid = getuidFromSession(session);

        //返回头像路径
        String avatar= "/upload" + filename;
        userService.changeAvatar(uid,avatar);
        //返回用户头像路径给前端页面，将来用于头像的展示使用
        return new Result<>(OK,avatar);
    }

}
