package main.first;

import main.Stats;

import org.apache.commons.math3.stat.descriptive.rank.Median;

/**
 * @author Wetterlund
 */
public class Stats1 extends Stats {
	private double[] sourceData;

	public Stats1(double[] sourceData) {
		this.sourceData = sourceData;
	}

	protected void calculateMedianValue() {
		try {
			Median statsHelper = new Median();

			statsHelper.setData(sourceData);

			medianValue = (int) statsHelper.evaluate();
		}
		catch (Exception e) {
			System.out.println(" The median value could not be calculated.");
		}
	}

}
