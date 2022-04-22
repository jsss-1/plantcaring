package com.acat.entity.userEntity.shoppingCenter;


public class WechatAuth {

  private long wechatAuthId;
  private long userId;
  private String openId;
  private java.sql.Timestamp createTime;
  // 个人信息，关系为一一对应
  private PersonInfo personInfo;

  public PersonInfo getPersonInfo() {
    return personInfo;
  }

  public void setPersonInfo(PersonInfo personInfo) {
    this.personInfo = personInfo;
  }

  public long getWechatAuthId() {
    return wechatAuthId;
  }

  public void setWechatAuthId(long wechatAuthId) {
    this.wechatAuthId = wechatAuthId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
