package com.acat.vo;

import lombok.Data;

@Data
public class ConditionVo {
    /**
     * 编号
     */
    private Integer  plantId;
    /**
     * 种类
     */
    private String kind;
    /**
     * 总体情况
     */
    private Integer general;
}
