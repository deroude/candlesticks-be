/*
 * (c)Viavi Solutions 2018
 * Last modified: Tuesday, 17th July 2018 8:19:37 pm
 * Author: Valentin Raduti (deroude@gmail.com>)
 */
package com.viavisolutions.candlesticks.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a single Data Point in a batch supplied from the server
 */
public class DataPoint {

    public static final Short TYPE_TABLET = 3, TYPE_MOBILE = 2, TYPE_DESKTOP = 1;

    @ApiModelProperty(notes = "The data point value")
    private Integer value;
    @ApiModelProperty(notes = "Type of data; one of 1 - Desktop, 2 - Mobile, or 3 - Tablet")
    private Short type;

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @return the type
     */
    public Short getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}