package com.acat.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName plant_condition
 */
@TableName(value ="plant_condition")
@Data
public class Condition implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Integer plantId;

    /**
     * 灌溉区连接
     */
    private Integer zoneId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 种类
     */
    private String kind;

    /**
     * 总体情况
     */
    private Integer general;
    /**
     *删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}