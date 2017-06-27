/**
 * 
 */
package main.second;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Wetterlund
 */
public class FileParse2 extends main.FileParse {
	private ArrayList<Integer>	valueArray	= new ArrayList<Integer>();

	public FileParse2(File sourceFile) {
		super(sourceFile);
	}

	protected void handleData(int data) throws Exception {
		valueArray.add(new Integer(data));
	}

	public ArrayList<Integer> getData() {
		return valueArray;
	}

}
