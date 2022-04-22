package com.acat.Mapper;

import com.acat.dao.mapper.ConditionMapper;
import com.acat.dao.pojo.Condition;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConditionMapperTest {
    @Autowired(required = false)
    private ConditionMapper conditionMapper;

    @Test
    public void selectAll(){
        List<Condition> conditions = conditionMapper.selectAll();
        System.out.println(conditions);
    }
    @Test
    public void selectByZoneId(){
        List<Condition> conditions = conditionMapper.selectByZoneId(1);
        System.out.println(conditions);
    }
    @Test
    public void selectByUserId(){
        List<Condition> conditions = conditionMapper.selectByUserId(1);
        System.out.println(conditions);
    }
    @Test
    public void insert(){
        Condition condition = new Condition();
        condition.setKind("水仙");
        condition.setGeneral(1);
        condition.setUserId(2);
        condition.setZoneId(1);
        Integer integer = conditionMapper.insertConditions(condition);
        System.out.println(integer);
    }
    @Test
    public void delete(){
        Integer integer = conditionMapper.deleteByPlantId(1);
        System.out.println(integer);
    }
    @Test
    public void update(){
        Condition condition = new Condition();
        condition.setPlantId(1);
        condition.setKind("水仙");
        condition.setGeneral(3);
        Integer integer = conditionMapper.updateByPlantId(condition);
        System.out.println(integer);
    }

}
