package com.acat.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName plant_zone
 */
@TableName(value ="plant_zone")
@Data
public class Zone implements Serializable {
    /**
     * 区域编号
     */
    @TableId(type = IdType.AUTO)
    private Integer zoneId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 名字
     */
    private String zoneName;

    /**
     * 温度
     */
    private Double temp;

    /**
     * 大气湿度
     */
    private Double hum;

    /**
     * 光照
     */
    private Double li;

    /**
     * 土壤湿度1
     */
    private Double sh;

    /**
     * 供肥浓度1
     */
    private Double manure;

    /**
     * 灌溉方式
     */
    private Integer fld;

    /**
     * 播种日期
     */
    private Date seedDate;

    /**
     * 上次灌溉日期
     */
    private Date lastIrrigateDate;

    /**
     * 灌溉区域类型
     */
    private Integer type;

    /**
     * 备注
     */
    private String remarks;
    /**
     *删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}