package com.n.weatherdataserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n.weatherdataserver.VO.WeatherResponse;
import com.n.weatherdataserver.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getWeatherDataByCityId(String cityId) {
        return getData(cityId);
    }

    @Override
    public WeatherResponse getWeatherDataByCityName(String cityName) {
        return getData(cityName);
    }

    private WeatherResponse getData(String city) {
        try {
            if (stringRedisTemplate.hasKey(city)) {
                ObjectMapper mapper = new ObjectMapper();
                String body = stringRedisTemplate.opsForValue().get(city);
                return mapper.readValue(stringRedisTemplate.opsForValue().get(city), WeatherResponse.class);
            }
        } catch (Exception e) {
            log.error("[获取天气数据]", e);
        }

        return null;
    }
}
