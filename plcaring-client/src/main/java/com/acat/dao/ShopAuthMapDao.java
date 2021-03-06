package com.acat.dao;

import com.acat.entity.userEntity.shoppingCenter.ShopAuthMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopAuthMapDao {
    /**
     * 分页列出店铺下面的授权信息
     *
     * @param shopId
     * @param pageSize
     * @return
     */
    List<ShopAuthMap> queryShopAuthMapListByShopId(@Param("shopId") long shopId, @Param("rowIndex") int rowIndex,
                                                   @Param("pageSize") int pageSize);

    /**
     * 获取授权总数
     *
     * @param shopId
     * @return
     */
    int queryShopAuthCountByShopId(@Param("shopId") long shopId);

    /**
     * 新增一条店铺与店员的授权关系
     *
     * @param shopAuthMap
     * @return effectedNum
     */
    int insertShopAuthMap(ShopAuthMap shopAuthMap);

    /**
     * 更新授权信息
     *
     * @param shopAuthMap
     * @return
     */
    int updateShopAuthMap(ShopAuthMap shopAuthMap);

    /**
     * 对某员工除权
     * @return effectedNum
     */
    int deleteShopAuthMap(long shopAuthId);

    /**
     * 通过shopAuthId查询员工授权信息
     *
     * @param shopAuthId
     * @return
     */
    ShopAuthMap queryShopAuthMapById(Long shopAuthId);
}
