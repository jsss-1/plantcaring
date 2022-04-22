package com.acat.service;



import com.acat.dto.ProductCategoryExecution;
import com.acat.entity.userEntity.shoppingCenter.ProductCategory;
import com.acat.exception.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     */
    List<ProductCategory> getProductCategoryList(long shopId);
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;

 ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
 throws ProductCategoryOperationException;
}
