package com.n.gateway.VO;

import lombok.Data;

import java.io.Serializable;


@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String low;
    private String sunrise;
    private String sunset;
    private Integer aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;
}
