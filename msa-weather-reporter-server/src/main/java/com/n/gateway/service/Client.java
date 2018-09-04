package com.n.gateway.service;


import com.n.gateway.VO.City;
import com.n.gateway.VO.WeatherResponse;
import com.n.gateway.service.impl.ClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msa-weather-proxy-server", fallback = ClientImpl.class)
public interface Client {
    @GetMapping("/city/city/list/{province}")
    List<City> getCityList(@PathVariable(value = "province") String province);

    @GetMapping("/city/city/province")
    List<String> getProvinceList();

    @GetMapping("/data/weather/cityName/{cityName}")
    WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName);
}
