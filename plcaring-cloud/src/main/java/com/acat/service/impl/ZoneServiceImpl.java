package com.acat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.acat.dao.pojo.Zone;
import com.acat.service.ZoneService;
import com.acat.dao.mapper.ZoneMapper;
import com.acat.service.ex.*;
import com.acat.vo.ZoneDataVo;
import com.acat.vo.ZoneVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Rain
* @description 针对表【plant_zone】的数据库操作Service实现
* @createDate 2022-04-02 16:47:01
*/
@Service
public class ZoneServiceImpl extends ServiceImpl<ZoneMapper, Zone>
        implements ZoneService{

    @Autowired(required = false)
    private ZoneMapper zoneMapper;


    @Override
    public List<ZoneVo> getAllMessage() {
        List<Zone> zones = zoneMapper.selectAll();
        //得到的集合为空则抛出异常
        if(zones.isEmpty()){
            throw new NotHaveZoneException("没有灌溉区");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        List<ZoneVo> zoneVos = copyList(zones);
        return zoneVos;
    }

    @Override
    public List<ZoneDataVo> getAllDate() {
        List<Zone> zones = zoneMapper.selectAll();
        //得到的集合为空则抛出异常
        if(zones.isEmpty()){
            throw new NotHaveZoneException("没有灌溉区");
        }
        //并不是所有都要返回给前端，所以拷贝一下
        List<ZoneDataVo> zoneVos = copyDateList(zones);
        return zoneVos;
    }

    @Override
    public ZoneVo getMessageByZoneId(Integer zoneId) {
        Zone result = zoneMapper.selectById(zoneId);
        //得到为空则抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new NotFindZoneException("没有编号为：" + zoneId + "的灌溉区");
        }
        ZoneVo zone = copy(result);
        return zone;
    }

    @Override
    public ZoneDataVo getDateByZoneId(Integer zoneId) {
        Zone result = zoneMapper.selectById(zoneId);
        //得到为空则抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new NotFindZoneException("没有编号为：" + zoneId + "的灌溉区");
        }
        ZoneDataVo zone = copyDate(result);
        return zone;
    }

    @Override
    public void updateByZoneId(Zone zone) {
        Integer zoneId = zone.getZoneId();
        //先判断灌溉区存不存在
        Zone result = zoneMapper.selectById(zoneId);
        //得到为空则抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new NotFindZoneException("没有编号为：" + zoneId + "的灌溉区");
        }

        int rows = zoneMapper.updateById(zone);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new UpdateException("修改产生未知异常");
        }
    }

    @Override
    public void deleteByZoneId(Integer zoneId) {
        //先判断灌溉区存不存在
        Zone result = zoneMapper.selectById(zoneId);
        //得到为空则抛出异常
        if(result == null || result.getIsDelete() == 1){
            throw new NotFindZoneException("没有编号为：" + zoneId + "的灌溉区");
        }

        Integer rows = zoneMapper.deleteByZoneId(zoneId);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new UpdateException("修改产生未知异常");
        }
    }

    @Override
    public void insertZone(Zone zone) {
        int rows = zoneMapper.insert(zone);
        //rows 改变行数 rows==1 改变成功 不为1抛出异常
        if(rows != 1){
            throw new InsertException("添加产生未知异常");
        }
    }

    /**
     *拷贝方法
     */
    private List<ZoneVo> copyList(List<Zone> zones) {
        List<ZoneVo> ZoneVoList = new ArrayList<ZoneVo>();
        for (Zone zone : zones) {
            ZoneVo zoneVo = copy(zone);
            ZoneVoList.add(zoneVo);
        }
        return ZoneVoList;
    }

    public ZoneVo copy(Zone zone){
        ZoneVo zoneVo= new ZoneVo();
        //BeanUtils.copyProperties 自带工具类
        BeanUtils.copyProperties(zone, zoneVo);
        return zoneVo;
    }

    /**
     *拷贝方法
     */
    private List<ZoneDataVo> copyDateList(List<Zone> zones) {
        List<ZoneDataVo> ZoneVoList = new ArrayList<ZoneDataVo>();
        for (Zone zone : zones) {
            ZoneDataVo zoneVo = copyDate(zone);
            ZoneVoList.add(zoneVo);
        }
        return ZoneVoList;
    }

    public ZoneDataVo copyDate(Zone zone){
        ZoneDataVo zoneVo= new ZoneDataVo();
        //BeanUtils.copyProperties 自带工具类
        BeanUtils.copyProperties(zone, zoneVo);
        return zoneVo;
    }
}




