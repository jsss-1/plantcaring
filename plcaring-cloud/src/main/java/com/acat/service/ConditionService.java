package com.acat.service;

import com.acat.dao.pojo.Condition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.acat.vo.ConditionVo;

import java.util.List;

/**
* @author Rain
* @description 针对表【plant_condition】的数据库操作Service
* @createDate 2022-04-02 16:38:39
*/
public interface ConditionService extends IService<Condition> {
    /**
     * 查询所有的Conditions
     */
    List<ConditionVo> selectAll();
    /**
     * 根据植物编号查找Condition
     */
    ConditionVo findByPlantId(Integer plantId);
    /**
     * 根据灌溉区Id查找植物情况
     */
    List<ConditionVo> findByZoneId(Integer zoneId);
    /**
     * 根据用户Id查找植物情况
     */
    List<ConditionVo> findByUserId(Integer userId);
    /**
     * 添加植物信息
     */
    void insertCondition(Condition condition);
    /**
     * 删除植物信息
     */
    void deleteByPlantId(Integer plantId);
    /**
     * 修改植物信息
     */
    void updateByPlantId( Condition condition);
}
