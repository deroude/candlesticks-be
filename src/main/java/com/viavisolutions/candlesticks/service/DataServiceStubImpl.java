/*
 * (c)Viavi Solutions 2018
 * Last modified: Tuesday, 17th July 2018 8:50:34 pm
 * Author: Valentin Raduti (deroude@gmail.com>)
 */
package com.viavisolutions.candlesticks.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.viavisolutions.candlesticks.domain.DataBatch;
import com.viavisolutions.candlesticks.domain.DataPoint;

import org.springframework.stereotype.Service;

/**
 * Stub implementation that returns 50-100 data points of random type and values
 * between 1 and 100
 */
@Service
public class DataServiceStubImpl implements DataService {
	private final Random rand = new Random();

	@Override
	public DataBatch getSnapshot() {
		DataBatch re = new DataBatch();
		re.setDate(LocalDateTime.now());
		List<DataPoint> points = new LinkedList<>();
		int nPoints = this.getRandomInt(50, 100);
		for (int i = 0; i < nPoints; i++) {
			DataPoint d = new DataPoint();
			d.setType((short) this.getRandomInt(1, 3));
			d.setValue(this.getRandomInt(1, 100));
			points.add(d);
		}
		re.setData(points);
		return re;
	}

	private final int getRandomInt(final int min, final int max) {
		return this.rand.nextInt(max - min + 1) + min;
	}

}