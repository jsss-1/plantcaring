package com.acat;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.acat.dao.pojo.Condition;
import com.acat.service.ConditionService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PlantCloudApplication.class)
@RunWith(SpringRunner.class)
public class MybatisTest {
    @Autowired
    private ConditionService conditionService;
    @Test
    public void insert(){
//        Condition condition = new Condition();
//        condition.setKind("xxxx");
//        conditionService.save(condition);
        BaseMapper<Condition> baseMapper = conditionService.getBaseMapper();
        System.out.println(baseMapper);
    }


}
