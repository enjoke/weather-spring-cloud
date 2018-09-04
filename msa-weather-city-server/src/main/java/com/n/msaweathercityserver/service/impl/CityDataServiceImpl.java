package com.n.msaweathercityserver.service.impl;


import com.n.msaweathercityserver.VO.City;
import com.n.msaweathercityserver.VO.CityList;
import com.n.msaweathercityserver.service.CityDataService;
import com.n.msaweathercityserver.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CityDataServiceImpl implements CityDataService {

    /**
     * 从文本文件获取城市信息
     * @return
     * @throws JAXBException
     */
    @Override
    public Map<String, List<City>> getCityList() throws JAXBException {

        Resource resource = new ClassPathResource("citylist.xml");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();
            return ((CityList) XmlBuilder.xmlStrToObject(CityList.class, sb.toString())).getCityMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取省份列表
     * @return
     * @throws JAXBException
     */
    @Override
    public List<String> getProvinceList() throws JAXBException {
        Map<String, List<City>> map =  getCityList();
        List<String> provinceList = new ArrayList<>();
        for(Map.Entry<String, List<City>> entry : map.entrySet()){
            provinceList.add(entry.getKey());
        }
        return provinceList;
    }
}