package com.acat.vo;

import lombok.Data;

@Data
public class ZoneDateVo {
    /**
     * 区域编号
     */
    private Integer zoneId;
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
}
