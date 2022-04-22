package com.acat.dao.mapper;

import com.acat.dao.pojo.Zone;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Rain
* @description 针对表【plant_zone】的数据库操作Mapper
* @createDate 2022-04-02 16:47:01
* @Entity com.acat.dao.pojo.Zone
*/
@Mapper
public interface ZoneMapper extends BaseMapper<Zone> {
    /**
     * 查找所有数据
     */
    List<Zone> selectAll();
    /**
     * 删除灌溉区
     */
    Integer deleteByZoneId(Integer zoneId);

}




