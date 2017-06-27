/**
 * 
 */
package main;

/**
 * @author Wetterlund
 */
public abstract class Stats {
	protected Integer medianValue;

	public Stats() {

	}

	protected abstract void calculateMedianValue();

	public int getMedianValue() {
		if (medianValue == null) {
			calculateMedianValue();
		}

		return medianValue;
	}
}
