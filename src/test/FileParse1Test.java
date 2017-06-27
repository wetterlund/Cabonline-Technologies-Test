package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import main.FileParse;
import main.Stats;
import main.first.FileParse1;
import main.first.Stats1;

import org.junit.Test;

public class FileParse1Test {

	@Test
	public void parseFileTest() {
		File sourcePath1_1 = new File("src/test/resources/test1-1.txt");

		FileParse1 test1_1 = new FileParse1(sourcePath1_1);
		try {
			test1_1.parseFile(FileParse.FILE_TYPE_ARRAY);
			Stats stats = new Stats1(test1_1.getData());

			assertEquals("Median should be 6", 6, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

		File sourcePath1_2 = new File("src/test/resources/test1-2.txt");

		FileParse1 test1_2 = new FileParse1(sourcePath1_2);
		try {
			test1_2.parseFile(FileParse.FILE_TYPE_LINES);
			Stats stats = new Stats1(test1_2.getData());

			assertEquals("Median should be 6", 6, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

		File sourcePath2_1 = new File("src/test/resources/test2-1.txt");

		FileParse1 test2_1 = new FileParse1(sourcePath2_1);
		try {
			test2_1.parseFile(FileParse.FILE_TYPE_ARRAY);
			Stats stats = new Stats1(test2_1.getData());

			assertEquals("Median should be 1000", 1000, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

		File sourcePath2_2 = new File("src/test/resources/test2-2.txt");

		FileParse1 test2_2 = new FileParse1(sourcePath2_2);
		try {
			test2_2.parseFile(FileParse.FILE_TYPE_LINES);
			Stats stats = new Stats1(test2_2.getData());

			assertEquals("Median should be 1000", 1000, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

		File sourcePath3_1 = new File("src/test/resources/test3-1.txt");

		FileParse1 test3_1 = new FileParse1(sourcePath3_1);
		try {
			test3_1.parseFile(FileParse.FILE_TYPE_ARRAY);
			Stats stats = new Stats1(test3_1.getData());

			assertEquals("Median should be 58", 58, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

		File sourcePath3_2 = new File("src/test/resources/test3-2.txt");

		FileParse1 test3_2 = new FileParse1(sourcePath3_2);
		try {
			test3_2.parseFile(FileParse.FILE_TYPE_LINES);
			Stats stats = new Stats1(test3_2.getData());

			assertEquals("Median should be 58", 58, stats.getMedianValue());
		}
		catch (Exception e) {
			fail("Exception parsing file.");
		}

	}

}
