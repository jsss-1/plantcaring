package com.acat.dao;


import com.acat.entity.userEntity.shoppingCenter.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shop id 查询店铺商品类别
     * @return List<ProductCategory>
     */
    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * 批量新增商品类别
     *
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return effectedNum
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
