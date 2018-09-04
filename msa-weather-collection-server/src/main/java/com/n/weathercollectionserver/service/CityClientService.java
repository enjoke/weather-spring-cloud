package com.n.weathercollectionserver.service;

import com.n.weathercollectionserver.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient("msa-weather-city-server")
public interface CityClientService {

    @GetMapping("/cities")
    Map<String, List<City>> getCityList();
}
