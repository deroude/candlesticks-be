/*
 * (c)Viavi Solutions 2018
 * Last modified: Tuesday, 17th July 2018 8:22:33 pm
 * Author: Valentin Raduti (deroude@gmail.com>)
 */
package com.viavisolutions.candlesticks.domain;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a timestamped batch of DataPoints supplied by the server
 */
public class DataBatch {
    @ApiModelProperty(notes = "The localized timestamp of the data batch")
    private LocalDateTime date;
    @ApiModelProperty(notes = "The ordered list of the data points captured in the batch")
    private List<DataPoint> data;

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @return the data
     */
    public List<DataPoint> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<DataPoint> data) {
        this.data = data;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}