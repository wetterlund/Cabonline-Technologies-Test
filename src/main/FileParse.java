/**
 * 
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wetterlund
 */
public abstract class FileParse {
	private File			sourceFile;

	public static final int	FILE_TYPE_ARRAY	= 1;
	public static final int	FILE_TYPE_LINES	= 2;

	public FileParse(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public void parseFile(int fileType) throws Exception {
		if (fileType == FILE_TYPE_ARRAY) {
			parseFileArray();
		}
		else {
			parseFileLines();
		}
	}

	private void parseFileArray() throws Exception {
		String arrayData = "";

		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(sourceFile), "UTF-8");
			char[] inReadbuf = new char[1024];
			int lenght;

			while ((lenght = inReader.read(inReadbuf)) != -1) {
				arrayData = arrayData.concat(String.valueOf(inReadbuf, 0, lenght));
			}
			inReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		arrayData = arrayData.replaceAll("[\\[\\]]", "");
		List<String> items = Arrays.asList(arrayData.split("\\s*(,\\s*)+"));
		for (String item : items) {
			processData(item);
		}

	}

	private void parseFileLines() throws Exception {
		String lineData;
		LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

		int count = 0;
		while ((lineData = reader.readLine()) != null) {
			try {
				processData(lineData);
			}
			catch (Exception e) {
				System.out.println(" Line " + (count + 1) + " skipped as data could not be parsed to integer: " + lineData);
				e.printStackTrace();
			}
			count++;
		}

		reader.close();

		System.out.println(" Number of lines (values) parsed in file " + count);
	}

	private void processData(String data) throws Exception {
		int value = Integer.parseInt(data);
		if (value > 1000) {
			value = 1000;
		}
		else if (value < 0) {
			value = 0;
		}

		handleData(value);
	}

	protected abstract void handleData(int data) throws Exception;

}
