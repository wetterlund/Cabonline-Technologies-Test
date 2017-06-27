/**
 * 
 */
package main.first;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Wetterlund
 */
public class FileParse1 extends main.FileParse {
	private ArrayList<Double>	valueArray	= new ArrayList<Double>();

	public FileParse1(File sourceFile) {
		super(sourceFile);
	}

	protected void handleData(int data) throws Exception {
		valueArray.add(new Double(data));
	}

	public double[] getData() {
		double[] values = new double[valueArray.size()];
		values = ArrayUtils.toPrimitive(valueArray.toArray(new Double[valueArray.size()]));

		return values;
	}

}
