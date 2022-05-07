package com.acat.dao.mapper;

import com.acat.dao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 用户注册
     * 插入方法
     */
    Integer insert(User user);

    /**
     * 用户的查找方法
     */
    User FindByUsername(String username);

    /**
     * 通过UID查找用户
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 根究用户的UID修改密码
     * @param uid
     * @return
     */
    Integer updatePasswordByUid(Integer uid, String password);

    /**
     *更新个人信息
     * @return
     */
    Integer updateInfoByUid(User user);

    /**
     * 上传头像
     * @param uid
     * @param avatar
     * @return
     * @Param("uid")  表示uid（后）与xml中的“uid”进行匹配 如果相同可以省略 故此时可以省略
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid, String avatar);
}
