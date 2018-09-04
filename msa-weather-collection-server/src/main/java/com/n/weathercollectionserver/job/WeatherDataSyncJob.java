package com.n.weathercollectionserver.job;

import com.n.weathercollectionserver.config.ConstConfig;
import com.n.weathercollectionserver.service.CityClientService;
import com.n.weathercollectionserver.service.WeatherDataCollectionService;
import com.n.weathercollectionserver.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Map;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private ConstConfig constConfig;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClientService cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        try {
            Map<String, List<City>> cityList= cityClient.getCityList();
            for (Map.Entry< String, List<City> > entry : cityList.entrySet()) {
                for(City city : entry.getValue()) {
                    Thread.sleep(constConfig.getSleep());
                    weatherDataCollectionService.syncDateByCityName(city.getCityName());
                    log.info("当前缓存城市id = {},城市名字={}", city.getCityId(), city.getCityName());
                }
            }
            log.info("WeatherDataSyncJob end ....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
