package com.acat.Service;

import com.acat.PlantCloudApplication;
import com.acat.dao.pojo.Zone;
import com.acat.service.ZoneService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PlantCloudApplication.class)
@RunWith(SpringRunner.class)
public class ZoneServiceTest {
    @Autowired
    private ZoneService zoneService;

    @Test
    public void selectAllMessage(){
        System.out.println(zoneService.getAllMessage());
    }
    @Test
    public void selectAllDate(){
        System.out.println(zoneService.getAllDate());
    }
    @Test
    public void selectById(){
//        System.out.println(zoneService.getDateByZoneId(1));
        System.out.println(zoneService.getMessageByZoneId(1));
    }
    @Test
    public void insert(){
        Zone zone = new Zone();
        zone.setZoneName("xxxx");
        zoneService.insertZone(zone);
    }
    @Test
    public void updete(){
        Zone zone = new Zone();
        zone.setZoneId(1);
        zone.setZoneName("一号");
        zoneService.updateByZoneId(zone);
    }
    @Test
    public void delete(){
        zoneService.deleteByZoneId(1);
    }
}
