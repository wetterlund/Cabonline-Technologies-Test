package main.first;

import org.apache.commons.math3.stat.descriptive.rank.Median;

/**
 * @author Wetterlund
 */
public class Stats {
	private double[] sourceData;
	private int medianValue;

	public Stats(double[] sourceData) {
		this.sourceData = sourceData;
	}

	public int retriveMedianValue() throws Exception {
		Median statsHelper = new Median();

		statsHelper.setData(sourceData);

		medianValue = (int) statsHelper.evaluate();

		return medianValue;
	}

}
