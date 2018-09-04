package com.n.weatherdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataServerApplication.class, args);
    }
}
