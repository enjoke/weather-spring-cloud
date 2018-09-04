package com.n.weatherdataserver.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    private String shidu;
    private String ganmao;
    private String wendu;
    private String quality;
    private Integer pm25;
    private Integer pm10;
    private Yesterday yesterday;
    private List<Yesterday> forecast;
}