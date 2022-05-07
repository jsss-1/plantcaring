package com.acat.service;

import com.acat.dao.pojo.User;

public interface UserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录功能
     */
    User login(String username, String password);

    /**
     * 修改密码
     */
    void changePassword(Integer uid, String oldPassword, String newPassword);

    /**
     * 根据用户uid查询用户的数据
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    /**
     * 更新用户信息
     * @param uid
     * @param username
     * @param user
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改头像
     * @param uid
     * @param avatar 头像路径名
     */
    void changeAvatar(Integer uid, String avatar);
}
