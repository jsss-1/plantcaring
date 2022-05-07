package com.acat.Service;

import com.acat.dao.pojo.Condition;
import com.acat.service.ConditionService;
import com.acat.vo.ConditionVo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConditionServiceTest {

    @Autowired
    private ConditionService conditionService;

    @Test
    public void selectAll(){
        List<ConditionVo> conditionVos = conditionService.selectAll();
        System.out.println(conditionVos);
    }

    @Test
    public void findByPlantId(){
        System.out.println(conditionService.findByPlantId(1));
    }
    @Test
    public void findByZoneId(){
        System.out.println(conditionService.findByZoneId(1));
    }
    @Test
    public void findByUserId(){
        System.out.println(conditionService.findByUserId(1));
    }
    @Test
    public void delete(){
        conditionService.deleteByPlantId(1);
    }
    @Test
    public void updateByPlantId(){
        Condition condition = new Condition();
        condition.setPlantId(1);
        condition.setKind("茉莉");
        condition.setGeneral(1);
        conditionService.updateByPlantId(condition);
    }
    @Test
    public void insert(){
        Condition condition = new Condition();
        condition.setKind("玫瑰");
        condition.setGeneral(1);
        condition.setUserId(2);
        condition.setZoneId(2);
        conditionService.insertCondition(condition);
    }
}
