package com.n.weatherdataserver.service;

import com.n.weatherdataserver.VO.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getWeatherDataByCityId(String cityId);

    WeatherResponse getWeatherDataByCityName(String cityName);
}
