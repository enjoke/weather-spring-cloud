package com.n.weathercollectionserver.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@Data
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City implements Serializable {

    @XmlTransient
    private static final long serialVersionUID = 4183704785465764806L;

    @XmlAttribute(name = "d1")
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "d4")
    private String province;

}