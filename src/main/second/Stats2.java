package main.second;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Wetterlund
 */
public class Stats2 {
	private ArrayList<Integer> sourceData;
	private int medianValue;

	public Stats2(ArrayList<Integer> sourceData) {
		this.sourceData = sourceData;
	}

	public int retriveMedianValue() throws Exception {
		Collections.sort(sourceData);

		medianValue = (int) sourceData.get((int) Math.ceil(sourceData.size() / 2));

		return medianValue;
	}

}
