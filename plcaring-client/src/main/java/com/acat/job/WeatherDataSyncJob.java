package com.acat.job;

import com.acat.service.WeatherDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherDataSyncJob extends QuartzJobBean {
//    @Autowired
//    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Weather Data Sync Job. Start!");
//        // 获取城市ID列表
//        List<City> cityList = null;
//        try {
//            cityList = cityDataService.listCity();
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//
//        // 遍历城市ID，获取天气
//        for (City city : cityList) {
//            String cityId = city.getCityId();
//            System.out.println("Weather Data Sync Job, cityId:" + cityId);
//            weatherDataService.syncDataByCityId(cityId);
//        }/  opppppppp
        System.out.println("Weather Data Sync Job. End!");
    }

}
