package com.acat.service.impl;

import com.acat.dao.mapper.UserMapper;
import com.acat.dao.pojo.User;
import com.acat.service.UserService;
import com.acat.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //通过user参数来获得传递过来的username
        String username = user.getUsername();
        //调用findByUsername（username）判断用户名是否被注册过
        User result = userMapper.FindByUsername(username);
        //判断结果集是否不为null则抛出用户名被占用的异常
        if(result!=null){
            //抛出异常
            throw new UsernameDuplicateException("用户名："+username+"被占用,请重新设置用户名");
        }

        //密码加密处理：MD5
        //串+密码+串 --》 MD5加密 串就是盐值
        String oldPassword = user.getPassword();
        //获取盐值（随机生成）大写：toUpperCase()
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据：盐值记录
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        //将加密后的密码重新补全设置到user对象中
        user.setPassword(md5Password);

        //补全数据:isDelete设置为0
        user.setIsDelete(0);

        //执行注册业务功能的实现（rows==1）
        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        //根据用户名称来查找用户数据是否存在，如果不存在则抛出异常
        User result = userMapper.FindByUsername(username);
        //判断isDelete是否为：1，为1表示用户已经被删除抛出用户不存在异常
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户不存在");
        }

        //验证用户密码是否正确，如果不正确则抛出异常
        //1.先获取数据库中加密后的密码
        String rightPassword = result.getPassword();
        //2.和用户的密码进行比较
        //2.1 先获取盐值salt
        String salt = result.getSalt();
        //2.3 将用户的密码按照相同的MD5加密后进行比较
        String newMD5Password = getMD5Password(password, salt);
        if(!rightPassword.equals(newMD5Password)){
            throw new PasswordNotMatchException("用户名或密码错误");
        }

        User user = new User();
        // 将以上信息封装到新的user对象中返回
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword) {
        // 获取对象 判断用户是否存在
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户不存在");
        }
        //原始密码与数据库中密码进行比较
        String oldmd5Password = getMD5Password(oldPassword, result.getSalt());
        if(!result.getPassword().equals(oldmd5Password)){
            throw new PasswordNotMatchException("原密码错误");
        }
        //将新的密码设置到数据库中
        String newmd5Password = getMD5Password(newPassword, result.getSalt());

        Integer rows = userMapper.updatePasswordByUid(uid, newmd5Password);
        //rows表示是否产生影响，不==1则表示未受到影响，抛出异常
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        // 获取对象 判断用户是否存在
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        // 创建新的User对象
        //为什么不直接返回:只需要返回需要的信息，有些信息用户不需要知道
        User user = new User();
        // 将以上查询结果中的username/phone/email/gender封装到新User对象中
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        // 返回新的User对象
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        //username 可以不使用
        // 获取对象 判断用户是否存在
        User result = userMapper.findByUid(uid);
        //如果不存在抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        //补全数据uid：因为传入的user对象中并没有包含uid
        user.setUid(uid);
        //进行更新信息
        Integer rows = userMapper.updateInfoByUid(user);
        //rows表示是否产生影响，不==1则表示未受到影响，抛出异常
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar) {
        //查询用户数据是否存在
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        //更新头像
        Integer rows = userMapper.updateAvatarByUid(uid, avatar);
        //rows表示是否产生影响，不==1则表示未受到影响，抛出异常
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }


    /**
     * MD5算法加密
     */
    private String getMD5Password(String password , String salt){
        for(int i =0; i < 3; i++){
            //MD5进行三次加密
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        //返回加密后的密码
        return password;
    }
}
