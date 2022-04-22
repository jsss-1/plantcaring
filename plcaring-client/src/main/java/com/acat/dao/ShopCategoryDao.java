package com.acat.dao;

import com.acat.entity.userEntity.shoppingCenter.ShopCatagory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
    /**
     * 根据传入的查询条件返回店铺类别列表
     *
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCatagory> queryShopCategory(@Param("shopCategoryCondition") ShopCatagory shopCategoryCondition);

    /**
     * 通过Id返回唯一的店铺类别信息
     * @return
     */
    ShopCatagory queryShopCategoryById(long shopCategoryId);

    /**
     * 根据传入的Id列表查询店铺类别信息(供超级管理员选定删除类别的时候用，主要是处理图片)
     *
     * @param shopCategoryIdList
     * @return
     */
    List<ShopCatagory> queryShopCategoryByIds(List<Long> shopCategoryIdList);

    /**
     * 插入一条店铺类别信息

     * @return
     */
    int insertShopCategory(ShopCatagory shopCatagory);

    /**
     * 更新店铺类别信息

     * @return
     */
    int updateShopCategory(ShopCatagory shopCatagory);

    /**
     * 删除店铺类别
     *
     * @param shopCategoryId
     * @return
     */
    int deleteShopCategory(long shopCategoryId);

    /**
     * 批量删除店铺类别
     *
     * @param shopCategoryIdList
     * @return
     */
    int batchDeleteShopCategory(List<Long> shopCategoryIdList);
}