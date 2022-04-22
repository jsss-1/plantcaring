package com.acat.service;

import com.acat.dao.pojo.Zone;
import com.baomidou.mybatisplus.extension.service.IService;
import com.acat.vo.ZoneDateVo;
import com.acat.vo.ZoneVo;

import java.util.List;

/**
* @author Rain
* @description 针对表【plant_zone】的数据库操作Service
* @createDate 2022-04-02 16:47:01
*/
public interface ZoneService extends IService<Zone> {
    /**
     * 获取灌溉区所有基本信息
     * @return
     */
    List<ZoneVo> getAllMessage();
    /**
     * 获取灌溉区所有数据信息
     */
    List<ZoneDateVo> getAllDate();
    /**
     * 根据zoneId获取基本信息
     */
    ZoneVo getMessageByZoneId(Integer zoneId);
    /**
     * 根据zoneId获取数据信息
     */
    ZoneDateVo getDateByZoneId(Integer zoneId);
    /**
     * 更改灌溉区数据
     */
    void updateByZoneId(Zone zone);
    /**
     * 删除灌溉区
     */
    void deleteByZoneId(Integer zoneId);
    /**
     * 添加新的灌溉区
     */
    void insertZone(Zone zone);
}
