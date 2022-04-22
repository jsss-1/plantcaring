package com.acat.service;

import com.acat.dto.UserProductMapExecution;
import com.acat.entity.userEntity.shoppingCenter.UserProductMap;
import com.acat.exception.UserProductMapOperationException;


public interface UserProductMapService {
	/**
	 * 通过传入的查询条件分页列出用户消费信息列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserProductMapExecution listUserProductMap(UserProductMap userProductCondition, Integer pageIndex,
											   Integer pageSize);

	/**
	 * 
	 * @param userProductMap
	 * @return
	 * @throws UserProductMapOperationException
	 */
	UserProductMapExecution addUserProductMap(UserProductMap userProductMap) throws UserProductMapOperationException;
}
