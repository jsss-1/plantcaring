package com.acat.service;


import com.acat.dto.WechatAuthExecution;
import com.acat.entity.userEntity.shoppingCenter.WechatAuth;
import com.acat.exception.WechatAuthOperationException;

public interface WechatAuthService {
    /**
     * 通过openId查找平台对应的微信帐号
     *
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    /**
     * 注册本平台的微信帐号
     *
     * @param wechatAuth

     * @return
     * @throws RuntimeException
     */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;

}
