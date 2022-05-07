package com.acat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.acat.dao.pojo.Condition;
import com.acat.service.ConditionService;
import com.acat.dao.mapper.ConditionMapper;
import com.acat.service.ex.InsertException;
import com.acat.service.ex.NotFindConditions;
import com.acat.service.ex.NotHaveConditionsException;
import com.acat.service.ex.UpdateException;
import com.acat.vo.ConditionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Rain
* @description 针对表【plant_condition】的数据库操作Service实现
* @createDate 2022-04-02 16:38:39
*/
@Service
public class ConditionServiceImpl extends ServiceImpl<ConditionMapper, Condition>
    implements ConditionService{

    @Autowired(required = false)
    private ConditionMapper conditionMapper;



    @Override
    public List<ConditionVo> selectAll() {
        List<Condition> conditions = conditionMapper.selectAll();
        //得到的集合为空则抛出异常
        if(conditions.isEmpty()){
            throw new NotHaveConditionsException("没有Conditions请添加后再尝试访问");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        List<ConditionVo> ConditionVoList = copyList(conditions);
        return ConditionVoList;
    }

    @Override
    public ConditionVo findByPlantId(Integer plantId) {
        Condition condition = conditionMapper.selectById(plantId);
        //找不到指定Condition抛出异常
        if(condition == null || condition.getIsDelete() == 1){
            throw new NotFindConditions("编号"+plantId+",找不到指定植物情况。");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        ConditionVo conditionVo = copy(condition);

        return conditionVo;
    }

    @Override
    public List<ConditionVo> findByZoneId(Integer zoneId) {
        List<Condition> conditions = conditionMapper.selectByZoneId(zoneId);
        //得到的集合为空则抛出异常
        if(conditions.isEmpty()){
            throw new NotFindConditions(zoneId + "此灌溉区没有植物");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        List<ConditionVo> ConditionVoList = copyList(conditions);
        return ConditionVoList;
    }

    @Override
    public List<ConditionVo> findByUserId(Integer userId) {
        List<Condition> conditions = conditionMapper.selectByZoneId(userId);
        //得到的集合为空则抛出异常
        if(conditions.isEmpty()){
            throw new NotFindConditions(userId + "此用户没有植物");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        List<ConditionVo> ConditionVoList = copyList(conditions);
        return ConditionVoList;
    }

    @Override
    public void insertCondition(Condition condition) {
        Integer rows = conditionMapper.insertConditions(condition);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new InsertException("添加信息是产生未知信息");
        }
    }

    @Override
    public void deleteByPlantId(Integer plantId) {
        //先判断要删除的数据存不存在
        Condition condition = conditionMapper.selectById(plantId);
        //找不到指定Condition抛出异常
        if(condition == null || condition.getIsDelete() == 1){
            throw new NotFindConditions("编号"+plantId+",找不到指定植物情况。");
        }

        Integer rows = conditionMapper.deleteByPlantId(plantId);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new UpdateException("删除产生未知异常");
        }
    }

    @Override
    public void updateByPlantId( Condition condition) {
        Integer plantId = condition.getPlantId();
        //先判断要修改的数据存不存在
        Condition result = conditionMapper.selectById(plantId);
        //找不到指定Condition抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new NotFindConditions("编号"+plantId+",找不到指定植物情况。");
        }

        Integer rows = conditionMapper.updateByPlantId(condition);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new UpdateException("修改产生未知异常");
        }
    }


    /**
     *拷贝方法
     */
    private List<ConditionVo> copyList(List<Condition> conditions) {
        List<ConditionVo> ConditionVoList = new ArrayList<ConditionVo>();
        for (Condition condition : conditions) {
            ConditionVo conditionVo = copy(condition);
            ConditionVoList.add(conditionVo);
        }
        return ConditionVoList;
    }

    public ConditionVo copy(Condition condition){
        ConditionVo conditionVo = new ConditionVo();
        //BeanUtils.copyProperties 自带工具类
        BeanUtils.copyProperties(condition, conditionVo);
        return conditionVo;
    }

}




