package com.acat.service;

import com.acat.entity.pushMessageEntity.weatherInfo.Weather;

public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
