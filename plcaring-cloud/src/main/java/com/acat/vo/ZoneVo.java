package com.acat.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ZoneVo {
    /**
     * 区域编号
     */
    private Integer zoneId;
    /**
     * 名字
     */
    private String zoneName;
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
}
