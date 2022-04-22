package com.acat;

import com.acat.dao.mapper.ConditionMapper;
import com.acat.dao.mapper.ZoneMapper;
import com.acat.service.ConditionService;
import com.acat.service.ZoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PlantCloudApplication.class)
@RunWith(SpringRunner.class)
public class BeanTest {

    @Autowired
    ZoneMapper zoneMapper;

    @Autowired
    ConditionMapper conditionMapper;

    @Autowired
    private ConditionService conditionService;

    @Autowired
    ZoneService zoneService;

    @Test
    public void test(){
        System.out.println(zoneMapper);
        System.out.println(conditionMapper);
        System.out.println(zoneService);
        System.out.println(conditionService);
    }

}
