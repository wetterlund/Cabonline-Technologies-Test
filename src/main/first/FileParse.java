/**
 * 
 */
package main.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Wetterlund
 */
public class FileParse {
	private File sourceFile;

	public FileParse(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public double[] parseFile() throws Exception {
		String readLine;
		Double value;
		ArrayList<Double> valueArray = new ArrayList<Double>();
		LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

		int count = 0;
		while ((readLine = reader.readLine()) != null) {
			try {
				value = new Double(Integer.parseInt(readLine));
				valueArray.add(value);
			}
			catch (Exception e) {
				System.out.println(" Line " + (count + 1) + " skipped as data could not be parsed to integer: " + readLine);
				e.printStackTrace();
			}
			count++;
		}

		reader.close();

		double[] values = new double[valueArray.size()];
		values = ArrayUtils.toPrimitive(valueArray.toArray(new Double[valueArray.size()]));

		System.out.println(" Number of lines (values) parsed in file " + count);

		return values;
	}
}
