package com.acat.service;


import com.acat.dto.ShopAuthMapExecution;
import com.acat.entity.userEntity.shoppingCenter.ShopAuthMap;
import com.acat.service.exceptions.ShopAuthMapOperationException;

public interface ShopAuthMapService {
	/**
	 * 根据店铺Id分页显示该店铺的授权信息
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize);

	/**
	 * 根据shopAuthId返回对应的授权信息
	 * 
	 * @param shopAuthId
	 * @return
	 */
	ShopAuthMap getShopAuthMapById(Long shopAuthId);

	/**
	 * 添加授权信息
	 * 
	 * @param shopAuthMap
	 * @return
	 * @throws ShopAuthMapOperationException
	 */
	ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

	/**
	 * 更新授权信息，包括职位，状态等
	 * @return
	 * @throws ShopAuthMapOperationException
	 */
	ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

}
