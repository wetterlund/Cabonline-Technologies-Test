package main;

import java.io.File;
import java.util.Date;

import main.first.FileParse;
import main.first.Stats;
import main.second.FileParse2;
import main.second.Stats2;

/**
 * @author Wetterlund
 */
public class CabonlineTechnologiesTest {

	private static int EXECUTION_ALL = 0;
	private static int EXECUTION_FIRST = 1;
	private static int EXECUTION_SECOND = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(" No source path as attribute. ");
			return;
		}

		String filePath = args[0].toString();
		File sourcePath = new File(filePath);
		File processedPath = new File(filePath + File.separator + "processed");

		String executionMode = null;
		if (args.length >= 2) {
			executionMode = args[1].toString();
		}
		System.out.println("Debug executionMode: " + executionMode);
		int executionModeFlag = getExecutionModeFlag(executionMode);

		System.out.println(" Processing files in (path name): " + filePath);
		System.out.println(" Processing files in (path absolute): " + sourcePath.getAbsolutePath());
		System.out.println(" Processed files are moved to: " + processedPath.getAbsolutePath());

		if (!sourcePath.isDirectory()) {
			System.out.println(" The source path is not a dir. " + filePath);
			return;
		}

		try {
			if (!processedPath.isDirectory()) {
				processedPath.mkdirs();
			}
			if (!processedPath.isDirectory()) {
				System.out.println(" The processed path is not a dir. " + processedPath);
				return;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}

		File[] sourceFiles = sourcePath.listFiles();
		if (sourceFiles == null || sourceFiles.length == 0) {
			System.out.println(" The source path do not contain any files. ");
			return;
		}

		Date startDate;
		int medianValue;
		for (int i = 0; i < sourceFiles.length; i++) {
			if (sourceFiles[i].isFile() == false) {
				continue;
			}

			System.out.println(" ----- ");

			try {
				String sourceFileName = sourceFiles[i].getName();

				System.out.println(" Processing file: " + sourceFileName);

				if (executionModeFlag == EXECUTION_ALL || executionModeFlag == EXECUTION_FIRST) {
					startDate = new Date();

					FileParse fileParse = new FileParse(sourceFiles[i]);
					Stats stats = new Stats(fileParse.parseFile());
					medianValue = stats.retriveMedianValue();

					System.out.println(" Median value in file was: " + medianValue);

					System.out.println(" Processed file " + sourceFileName + " in " + ((new Date()).getTime() - startDate.getTime()) + " ms with variant 1");
					System.out.println(" Memory total: " + Runtime.getRuntime().totalMemory() / 1048576 + " MB / max: " + Runtime.getRuntime().maxMemory()
							/ 1048576 + " MB / free: " + Runtime.getRuntime().freeMemory() / 1048576 + " MB");
				}

				if (executionModeFlag == EXECUTION_ALL || executionModeFlag == EXECUTION_SECOND) {
					startDate = new Date();

					FileParse2 fileParse2 = new FileParse2(sourceFiles[i]);
					Stats2 stats2 = new Stats2(fileParse2.parseFile());
					medianValue = stats2.retriveMedianValue();

					System.out.println(" Median value in file was: " + medianValue);

					System.out.println(" Processed file " + sourceFileName + " in " + ((new Date()).getTime() - startDate.getTime()) + " ms with variant 2");
					System.out.println(" Memory total: " + Runtime.getRuntime().totalMemory() / 1048576 + " MB / max: " + Runtime.getRuntime().maxMemory()
							/ 1048576 + " MB / free: " + Runtime.getRuntime().freeMemory() / 1048576 + " MB");
				}

				File processedFile = new File(processedPath, sourceFileName);
				sourceFiles[i].renameTo(processedFile);
			}
			catch (Exception e) {
				System.out.println(" There where an exception while parsing the file so no median value could be retrived.");

				e.printStackTrace();
			}
		}
	}

	private static int getExecutionModeFlag(String executionMode) {
		try {
			int executionModeInt = Integer.parseInt(executionMode);
			if (executionModeInt == EXECUTION_FIRST) {
				return EXECUTION_FIRST;
			}
			else if (executionModeInt == EXECUTION_SECOND) {
				return EXECUTION_SECOND;
			}
			else {
				return EXECUTION_ALL;
			}
		}
		catch (Exception e) {
			return EXECUTION_ALL;
		}
	}
}
