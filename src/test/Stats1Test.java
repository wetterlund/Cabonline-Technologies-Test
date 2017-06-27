package test;

import static org.junit.Assert.assertEquals;
import main.first.Stats1;

import org.junit.Test;

public class Stats1Test {

	@Test
	public void calculateMedianValueTest() {
		double[] values1 = { 4, 1, 6, 3, 7, 8, 7 };
		Stats1 test1 = new Stats1(values1);
		assertEquals("Median should be 6", 6, test1.getMedianValue());

		double[] values2 = { 1, 2, 3, 1000, 1000 };
		Stats1 test2 = new Stats1(values2);
		assertEquals("Median should be 3", 3, test2.getMedianValue());

		double[] values3 = { 14, 81, 59, 17, 80, 53, 77, 93, 48, 50, 18, 83, 6, 31, 10, 74, 83, 70, 98, 69, 31, 88, 37, 98, 9, 91, 9, 10, 99, 78, 31, 56, 83,
				71, 90, 51, 22, 59, 44, 76, 18, 29, 58, 87, 84, 39, 73, 68, 85, 55, 91, 70, 51, 54, 26, 98, 94, 87, 8, 27, 14, 87, 86, 44, 65, 98, 69, 57, 17,
				75, 70, 62, 55, 78, 59, 98, 66, 68, 21, 28, 39, 15, 46, 90, 92, 30, 30, 33, 51, 71, 2, 10, 13, 62, 55, 39, 14, 96, 48 };
		Stats1 test3 = new Stats1(values3);
		assertEquals("Median should be 58", 58, test3.getMedianValue());

	}
}
