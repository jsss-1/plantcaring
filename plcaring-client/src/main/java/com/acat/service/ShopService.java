package com.acat.service;


import com.acat.dto.ImageHolder;
import com.acat.dto.ShopExecution;
import com.acat.entity.userEntity.shoppingCenter.Shop;
import com.acat.exception.ShopOperationException;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     *
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 通过id获取店铺信息
     */
    public Shop getByShopId(long shopId);

    /**
     * 更改店铺信息
     */
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /**
     * @param shop
     * @return
     */
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail);

}
