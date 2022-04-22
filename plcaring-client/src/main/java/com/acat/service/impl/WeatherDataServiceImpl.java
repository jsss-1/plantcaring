package com.acat.service.impl;

import com.acat.entity.pushMessageEntity.weatherInfo.WeatherResponse;
import com.acat.service.WeatherDataService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RestTemplate restTemplate;
    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 缓存超时时间
     */
    private final Long TIME_OUT = 1800L;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //将调用的uri作为缓存的key
        String strBody = null;
        //先查缓存，没有找到查服务
        if (!stringRedisTemplate.hasKey(uri)) {

            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            if (response.getStatusCodeValue() == 200) {
                strBody = response.getBody();
            }
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        } else {
            // logger.info("找到 key " + uri + ",value=" + ops.get(uri));
            strBody = ops.get(uri);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        cityName="西安";
        String uri = WEATHER_API + "?city=" + cityName;
        return this.doGetWeatherData(uri);
    }

    @Override
    public void syncDataByCityId(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        if (200 == responseEntity.getStatusCodeValue()) {
            strBody = responseEntity.getBody();
        }
        ops.set(key, strBody, 1800L, TimeUnit.SECONDS);
    }
}
