package com.acat.service;


import com.acat.dto.ImageHolder;
import com.acat.dto.ShopCategoryExecution;
import com.acat.entity.userEntity.shoppingCenter.ShopCatagory;

import java.util.List;

public interface ShopCategoryService {
    public static final String SCLISTTKEY ="shopcategorylist";
    /**
     * 根据查询条件获取category列表
     */
    List<ShopCatagory> getShopCategoryList(ShopCatagory shopCategoryCondition);
    /**
     * 添加店铺类别，并存储店铺类别图片
     */
    ShopCategoryExecution addShopCategory(ShopCatagory shopCatagory, ImageHolder thumbnail);

    /**
     * 修改店铺类别
     * @param shopCatagory
     * @param thumbnail
     * @return
     */
    ShopCategoryExecution modifyShopCategory(ShopCatagory shopCatagory,ImageHolder thumbnail);
    /**
     * 根据id返回店铺信息
     */
    ShopCatagory getShopCategoryById(Long shopCategoryId);



}
