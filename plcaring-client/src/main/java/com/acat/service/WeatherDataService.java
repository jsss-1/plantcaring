package com.acat.service;

import com.acat.entity.pushMessageEntity.weatherInfo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);
    WeatherResponse getDataByCityName(String cityName);
    /**
     * 根据城市id来同步天气
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
