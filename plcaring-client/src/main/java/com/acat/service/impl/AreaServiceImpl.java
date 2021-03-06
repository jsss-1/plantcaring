package com.acat.service.impl;

import com.acat.cache.JedisUtil;
import com.acat.common.enums.AreaStateEnum;
import com.acat.dao.AreaDao;
import com.acat.dto.AreaExecution;
import com.acat.entity.userEntity.shoppingCenter.Area;
import com.acat.exception.AreaOptionException;
import com.acat.service.AreaService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    private JedisUtil jedisUtil=new JedisUtil();

   /* @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;*/


    @Override
    @Transactional
    public List<Area> getAreaList() {
// 定义redis的key
        String key = AREALISTKEY;
        // 定义接收对象
        List<Area> areaList = null;
        // 定义jackson数据转换操作类
        ObjectMapper mapper = new ObjectMapper();
        // 判断key是否存在
        if (!jedisUtil.getKeys().exists(key)) {
            // 若不存在，则从数据库里面取出相应数据
            areaList = areaDao.queryArea();
            // 将相关的实体类集合转换成string,存入redis里面对应的key中
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(areaList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new AreaOptionException(e.getMessage());
            }
            jedisUtil.getStrings().set(key, jsonString);
        } else {
            // 若存在，则直接从redis里面取出相应数据
            String jsonString = jedisUtil.getStrings().get(key);
            // 指定要将string转换成的集合类型
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
            try {
                // 将相关key对应的value里的的string转换成对象的实体类集合
                areaList = mapper.readValue(jsonString, javaType);
            } catch (JsonParseException e) {
                e.printStackTrace();
                throw new AreaOptionException(e.getMessage());
            } catch (JsonMappingException e) {
                e.printStackTrace();
                throw new AreaOptionException(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                throw new AreaOptionException(e.getMessage());
            }
        }
        return areaList;
    }

    @Override
    public AreaExecution addArea(Area area) {
        // 空值判断，主要是判断areaName不为空
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            // 设置默认值
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    deleteRedis4Area();
                    return new AreaExecution(AreaStateEnum.SUCCESS, area);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new AreaOptionException("添加区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }

    @Override
    public AreaExecution modifyArea(Area area) {
        // 空值判断，主要是areaId不为空
        if (area.getAreaId() > 0) {
            // 设置默认值
            area.setLastEditTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    deleteRedis4Area();
                    return new AreaExecution(AreaStateEnum.SUCCESS, area);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new AreaOptionException("更新区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }

    /**
     * 移除跟实体类相关的redis key-value
     */
    private void deleteRedis4Area() {
        String key = AREALISTKEY;
        // 若redis存在对应的key,则将key清除
        if (jedisUtil.getKeys().exists(key)) {
            jedisUtil.getKeys().del(key);
        }
    }

}
