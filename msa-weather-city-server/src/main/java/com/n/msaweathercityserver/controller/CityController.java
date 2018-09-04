package com.n.msaweathercityserver.controller;

import com.n.msaweathercityserver.VO.City;
import com.n.msaweathercityserver.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 提供省份，城市列表
 */

@RestController
@RequestMapping
public class CityController {
    @Autowired
    private CityDataService cityDataService;

    /**
     * 根据省份获取城市列表
     * @param province
     * @return
     * @throws Exception
     */
    @GetMapping("/city/list/{province}")
    @Cacheable("province")
    public List<City> getCityByProvince(@PathVariable(value = "province") String province) throws Exception {
        return cityDataService.getCityList().get(province);
    }

    /**
     * 获取省份跟城市
     * @return
     * @throws Exception
     */
    @GetMapping("/cities")
    @Cacheable("cities")
    public Map<String, List<City>> cities() throws Exception{
        return cityDataService.getCityList();
    }

    /**
     * 获取省份列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/province")
    @Cacheable("provinceList")
    public List<String> getProvinceList() throws Exception {
        return cityDataService.getProvinceList();
    }
}