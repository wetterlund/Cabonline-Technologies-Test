/**
 * 
 */
package main.second;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * @author Wetterlund
 */
public class FileParse2 {
	private File sourceFile;

	public FileParse2(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public ArrayList<Integer> parseFile() throws Exception {
		String readLine;
		Integer value;
		ArrayList<Integer> valueArray = new ArrayList<Integer>();
		LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

		int count = 0;
		while ((readLine = reader.readLine()) != null) {
			try {
				value = new Integer(readLine);
				valueArray.add(value);
			}
			catch (Exception e) {
				System.out.println(" Line " + (count + 1) + " skipped as data could not be parsed to integer: " + readLine);
				e.printStackTrace();
			}
			count++;
		}

		reader.close();

		System.out.println(" Number of lines (values) parsed in file " + count);

		return valueArray;
	}
}
