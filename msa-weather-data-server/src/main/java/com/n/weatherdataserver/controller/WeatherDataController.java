package com.n.weatherdataserver.controller;


import com.n.weatherdataserver.VO.WeatherResponse;
import com.n.weatherdataserver.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 天气信息读取服务：从redis缓存中获取相应城市天气信息
 */
@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

//    @GetMapping("/cityId/{cityId}")
//    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
//        return weatherDataService.getWeatherDataByCityId(cityId);
//    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getWeatherDataByCityName(cityName);
    }
}
