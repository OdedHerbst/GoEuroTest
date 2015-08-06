package utils;

import java.io.File;

import configuration.SystemConfig;

public class Utils {

	private static final String fileExtention = ".csv";

	public static String buildFullUrl(String input) {
		StringBuilder sb = new StringBuilder(SystemConfig.getApiPrefix());
		sb.append(input);

		return sb.toString();
	}

	/**
	 * The filename will be constructed by filename_* where the * is an index in
	 * order NOT to overwrite existing files
	 * 
	 * @param filename
	 *            - desired filename
	 * @param index
	 * @return a file pointer with a valid name
	 */
	public static File generateCsvFilename(String filename) {
		// Using 0 in order to create the original filename
		int i = 0;
		File file = new File(generateCsvFilename(filename, i));

		while (file.exists()) {
			i++;
			file = new File(generateCsvFilename(filename, i));
		}

		return file;
	}

	/**
	 * Generate the filename with the index
	 * 
	 * @param filename
	 * @param i
	 * @return
	 */
	private static String generateCsvFilename(String filename, int i) {
		StringBuilder sb = new StringBuilder();
		char concat = '_';

		sb.append(filename);
		if (i != 0) {
			sb.append(concat);
			sb.append(i);
		}
		sb.append(fileExtention);

		return sb.toString();
	}
}
