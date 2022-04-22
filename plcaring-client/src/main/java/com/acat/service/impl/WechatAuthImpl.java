package com.acat.service.impl;


import com.acat.dao.PersonInfoDao;
import com.acat.dao.WechatAuthDao;
import com.acat.dto.WechatAuthExecution;
import com.acat.entity.userEntity.shoppingCenter.WechatAuth;
import com.acat.exception.WechatAuthOperationException;
import com.acat.service.WechatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatAuthImpl implements WechatAuthService {

    @Autowired
    private WechatAuthDao wechatAuthDao;
    @Autowired
    private PersonInfoDao personInfoDao;

    @Override
    public WechatAuth getWechatAuthByOpenId(String openId) {
        return null;
    }

    @Override
    public WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException {
        return null;
    }
}
