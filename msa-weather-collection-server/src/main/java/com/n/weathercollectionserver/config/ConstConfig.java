package com.n.weathercollectionserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "weather")
public class ConstConfig {

    private String url;

    private Integer timeout;

    private Integer interval;

    private Integer sleep;
}
