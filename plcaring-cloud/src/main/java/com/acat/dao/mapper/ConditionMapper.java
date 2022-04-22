package com.acat.dao.mapper;

import com.acat.dao.pojo.Condition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Rain
* @description 针对表【plant_condition】的数据库操作Mapper
* @createDate 2022-04-02 16:38:39
* @Entity com.acat.dao.pojo.Condition
*/
@Mapper
public interface ConditionMapper extends BaseMapper<Condition> {
    /**
     * 查询所有condition
     */
    List<Condition> selectAll();
    /**
     * 根据灌溉区编号查询植物情况
     */
    List<Condition> selectByZoneId(Integer zoneId);
    /**
     * 根据用户Id查询植物情况
     */
    List<Condition> selectByUserId(Integer userId);
    /**
     * 插入植物情况
     */
    Integer insertConditions(Condition condition);
    /**
     * 删除植物数据
     */
    Integer deleteByPlantId(Integer plantId);
    /**
     * 更改植物信息
     */
    Integer updateByPlantId(Condition condition);
}




