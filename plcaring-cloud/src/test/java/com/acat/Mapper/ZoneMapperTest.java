package com.acat.Mapper;

import com.acat.dao.mapper.ZoneMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZoneMapperTest {
    @Autowired(required = false)
    private ZoneMapper zoneMapper;

    @Test
    public void selectAll(){
        System.out.println(zoneMapper.selectAll());

    }
    @Test
    public void delete(){
        System.out.println(zoneMapper.deleteByZoneId(1));
    }
}
