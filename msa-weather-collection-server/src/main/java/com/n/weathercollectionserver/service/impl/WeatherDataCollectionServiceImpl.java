package com.n.weathercollectionserver.service.impl;

import com.n.weathercollectionserver.config.ConstConfig;
import com.n.weathercollectionserver.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    @Autowired
    private ConstConfig constConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDateByCityName(String cityName) {
        this.saveWeatherData(cityName);
    }

    private void saveWeatherData(String cityName) {
        ResponseEntity<String> respString = restTemplate.getForEntity(constConfig.getUrl() + cityName, String.class);

        if (respString.getStatusCodeValue() == 200) {
            stringRedisTemplate.opsForValue().set(cityName, respString.getBody(), constConfig.getTimeout(), TimeUnit.SECONDS);
        }

    }

}
