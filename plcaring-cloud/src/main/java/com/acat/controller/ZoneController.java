package com.acat.controller;

import com.acat.dao.pojo.Zone;
import com.acat.service.ZoneService;
import com.acat.util.Result;
import com.acat.vo.ZoneDataVo;
import com.acat.vo.ZoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("zones")
public class ZoneController extends BaseController {
    @Autowired
    private ZoneService zoneService;

    @RequestMapping("all_message")
    public Result<List<ZoneVo>> getAllMessage(){
        List<ZoneVo> allMessage = zoneService.getAllMessage();
        return new Result<>(OK,allMessage);
    }

    @RequestMapping("all_data")
    public Result<List<ZoneDataVo>> getAllDate(){
        List<ZoneDataVo> allDate = zoneService.getAllDate();
        return new Result<>(OK,allDate);
    }

    @RequestMapping("get_message_by_zoneId")
    public Result<ZoneVo> getMessageByZoneId(Integer zoneId){
        ZoneVo zone = zoneService.getMessageByZoneId(zoneId);
        return new Result<>(OK,zone);
    }

    @RequestMapping("get_data_by_zoneId")
    public Result<ZoneDataVo> getDateByZoneId(Integer zoneId){
        ZoneDataVo zone = zoneService.getDateByZoneId(zoneId);
        return new Result<>(OK,zone);
    }

    @RequestMapping("update_by_zoneId")
    public Result<Void> updateByZoneId(Zone zone){
        zoneService.updateByZoneId(zone);
        return new Result<>(OK);
    }

    @RequestMapping("insert_zone")
    public Result<Void> insertZone(Zone zone){
        zoneService.insertZone(zone);
        return new Result<>(OK);
    }

    @RequestMapping("delete_by_zoneId")
    public Result<Void> deleteByZone(Integer zoneId){
        zoneService.deleteByZoneId(zoneId);
        return new Result<>(OK);
    }
}
