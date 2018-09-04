package com.n.gateway.controller;


import com.n.gateway.VO.City;
import com.n.gateway.VO.WeatherResponse;
import com.n.gateway.service.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/reporter")
@Slf4j
public class WeatherReporterController {

    @Autowired
    private Client client;

    @GetMapping("/index")
    public ModelAndView getReporter(@RequestParam(value = "province", required = false, defaultValue = "广东") String province,
                                    @RequestParam(value = "cityName", required = false) String cityName,
                                    Model model){

        return getData(province, cityName, model);
    }

    @GetMapping("/{province}/{cityName}")
    public ModelAndView getReporterByCityName(@PathVariable("province") String province,
                                               @PathVariable("cityName") String cityName, Model model){
        return getData(province, cityName, model);
    }

    private ModelAndView getData(String province, String cityName, Model model) {
        List<City> list = client.getCityList(province);
        if(CollectionUtils.isEmpty(list)) {
            log.error("city sever return null city list");
            return error(model);
        }
        if(StringUtils.isEmpty(cityName)){
            cityName = list.get(0).getCityName();
        }
        List<String> provinces = client.getProvinceList();
        if(null == provinces){
            log.error("city server return null province list");
            return error(model);
        }
        WeatherResponse response = client.getWeatherDataByCityName(cityName);
        if(null == response){
            log.error("data server return null repose");
            return error(model);
        }
        model.addAttribute("title", "据说天气预报");
        model.addAttribute("provinceName", province);
        model.addAttribute("provinceList", provinces);
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", list);
        model.addAttribute("report", response.getData());

        return new ModelAndView("weather/report", "reportModel", model);
    }

    private ModelAndView error(Model model) {
        model.addAttribute("msg", "服务暂不可用，请稍后再试！");
        return new ModelAndView("weather/error", "reportModel", model);
    }
}
