package com.acat.dto;


import com.acat.common.enums.ShopCategoryStateEnum;
import com.acat.entity.userEntity.shoppingCenter.ShopCatagory;

import java.util.List;

public class ShopCategoryExecution {
    //    结果状态
    private int state;
    //    状态标识
    private String stateInfo;
    private ShopCatagory shopCatagory;
    private List<ShopCatagory> shopCatagoryList;

    public ShopCategoryExecution() {

    }

    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum, ShopCatagory shopCatagory){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopCatagory =shopCatagory;
    }
    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum,ShopCatagory shopCatagory,List<ShopCatagory> shopCatagoryList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopCatagory =shopCatagory;
        this.shopCatagoryList = shopCatagoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public ShopCatagory getShopCatagory() {
        return shopCatagory;
    }

    public void setShopCatagory(ShopCatagory shopCatagory) {
        this.shopCatagory = shopCatagory;
    }

    public List<ShopCatagory> getShopCatagoryList() {
        return shopCatagoryList;
    }

    public void setShopCatagoryList(List<ShopCatagory> shopCatagoryList) {
        this.shopCatagoryList = shopCatagoryList;
    }

    @Override
    public String toString() {
        return "ShopCategoryExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", shopCatagory=" + shopCatagory +
                ", shopCatagoryList=" + shopCatagoryList +
                '}';
    }
}
