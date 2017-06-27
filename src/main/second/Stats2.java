package main.second;

import java.util.ArrayList;
import java.util.Collections;

import main.Stats;

/**
 * @author Wetterlund
 */
public class Stats2 extends Stats {
	private ArrayList<Integer> sourceData;

	public Stats2(ArrayList<Integer> sourceData) {
		this.sourceData = sourceData;
	}

	protected void calculateMedianValue() {
		try {
			Collections.sort(sourceData);

			medianValue = (int) sourceData.get((int) Math.ceil(sourceData.size() / 2));
		}
		catch (Exception e) {
			System.out.println(" The median value could not be calculated.");
		}
	}

}
