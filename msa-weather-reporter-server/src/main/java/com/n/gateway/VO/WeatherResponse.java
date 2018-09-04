package com.n.gateway.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String date;
    private String message;
    private String city;
    private Integer count;
}
