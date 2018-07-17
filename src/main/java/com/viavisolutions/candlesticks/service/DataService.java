/*
 * (c)Viavi Solutions 2018
 * Last modified: Tuesday, 17th July 2018 8:23:55 pm
 * Author: Valentin Raduti (deroude@gmail.com>)
 */
package com.viavisolutions.candlesticks.service;

import com.viavisolutions.candlesticks.domain.DataBatch;

/**
 * API for a data stream factory that returns a Stream of {@link DataBatch}
 */
public interface DataService {
    public DataBatch getSnapshot();
}