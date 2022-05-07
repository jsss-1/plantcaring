package com.acat.Mapper;

import com.acat.dao.mapper.UserMapper;
import com.acat.dao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Test
    public void insert(){
        User user = new User();
        System.out.println("1");
        user.setUsername("lxy");
        user.setPassword("123");
        user.setPhone("123");
        user.setEmail("123");
        user.setGender(1);
        userMapper.insert(user);
    }

    @Test
    public void FindByUsername(){
        User user = userMapper.FindByUsername("lxy");
        System.out.println(user);
    }

    @Test
    public void findByUid(){
        User user = userMapper.findByUid(7);
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        Integer integer = userMapper.updatePasswordByUid(6,"111");
        System.out.println(integer);
    }
    @Test
    public void updateByUid(){
        User user = new User();
        user.setUid(6);
        user.setPhone("12321312312312");
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println(rows);

    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(6, "123");
    }
}
