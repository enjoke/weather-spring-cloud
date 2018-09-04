package com.n.msaweathercityserver.VO;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> cityList;

    @XmlTransient
    private Map<String, List<City>> cityMap;

    private void groupByProvince(){

        cityMap = new HashMap<>();
        String key = cityList.get(0).getProvince();
        List<City> list = new ArrayList<>();
        cityMap.put(key, list);
        for (City city :cityList) {
            key = city.getProvince();
            if(cityMap.containsKey(city.getProvince())){
                cityMap.get(key).add(city);
            } else {
                list = new ArrayList<>();
                list.add(city);
                cityMap.put(key, list);
            }
        }
    }

    public Map<String, List<City>> getCityMap() {
        groupByProvince();
        return cityMap;
    }
}