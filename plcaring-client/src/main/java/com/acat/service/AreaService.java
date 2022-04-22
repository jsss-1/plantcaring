package com.acat.service;


import com.acat.dto.AreaExecution;
import com.acat.entity.userEntity.shoppingCenter.Area;

import java.util.List;

public interface AreaService {
    public static final String AREALISTKEY = "arealist";
    /**
     * 获取区域列表，优先从缓存获取
     */
    List<Area> getAreaList();
    /**
     * 增加区域信息
     * @return
     */
    AreaExecution addArea(Area area);
    AreaExecution modifyArea(Area area);
}
