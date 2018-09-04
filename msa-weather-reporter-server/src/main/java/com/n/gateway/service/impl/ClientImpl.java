package com.n.gateway.service.impl;

import com.n.gateway.VO.City;
import com.n.gateway.VO.WeatherResponse;
import com.n.gateway.service.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientImpl implements Client {
    @Override
    public List<City> getCityList(String province) {
        return null;
    }

    @Override
    public List<String> getProvinceList() {
        return null;
    }

    @Override
    public WeatherResponse getWeatherDataByCityName(String cityName) {
        return null;
    }
}
