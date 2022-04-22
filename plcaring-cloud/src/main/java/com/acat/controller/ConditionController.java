package com.acat.controller;

import com.acat.controller.ex.BaseController;
import com.acat.dao.pojo.Condition;
import com.acat.service.ConditionService;
import com.acat.util.Result;
import com.acat.vo.ConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("conditions")
public class ConditionController extends BaseController {
    @Autowired
    private ConditionService conditionService;

    @RequestMapping("all")
    public Result<List<ConditionVo>> selectAll(){
        List<ConditionVo> conditionVoList = conditionService.selectAll();
        return new Result<List<ConditionVo>>(OK,conditionVoList);
    }

    @RequestMapping("get_by_plantId")
    public Result<ConditionVo> getByPlantId(Integer plantId){
        ConditionVo conditionVo = conditionService.findByPlantId(plantId);
        return new Result<>(OK,conditionVo);
    }

    @RequestMapping("get_by_zoneId")
    public Result<List<ConditionVo>> getByZoneId(Integer zoneId){
        List<ConditionVo> conditionVoList = conditionService.findByZoneId(zoneId);
        return new Result<>(OK,conditionVoList);
    }

    @RequestMapping("get_by_userId")
    public Result<List<ConditionVo>> getByUserId(Integer userId){
        List<ConditionVo> conditionVoList = conditionService.findByUserId(userId);
        return new Result<>(OK,conditionVoList);
    }

    @RequestMapping("insert_condition")
    public Result<Void> insertCondition(Condition condition){
        conditionService.insertCondition(condition);
        return new Result<>(OK);
    }

    @RequestMapping("update_by_plantId")
    public Result<Void> updateByPlantId(Condition condition){
        conditionService.updateByPlantId(condition);
        return new Result<>(OK);
    }

    @RequestMapping("delete_by_plantId")
    public Result<Void> deleteByPlantId(Integer plantId){
        conditionService.deleteByPlantId(plantId);
        return new Result<>(OK);
    }

}
