package com.acat.service.impl;

import com.acat.entity.pushMessageEntity.weatherInfo.Weather;
import com.acat.entity.pushMessageEntity.weatherInfo.WeatherResponse;
import com.acat.service.WeatherDataService;
import com.acat.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityId);
        return response.getData();
    }
}
