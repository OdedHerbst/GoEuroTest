package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import exceptions.ApiException;
import exceptions.ErrorConstants;

/**
 * Holds methods for working with files
 * 
 * @author oded herbst
 * 
 */
public class DataSourceUtils {

	/**
	 * Writes content to a file using apache common utils
	 * 
	 * @param content
	 *            - String content to be written
	 * @param file
	 *            - a valid file
	 * @throws ApiException
	 */
	public static void writeFile(String content, File file) throws ApiException {
		if (StringUtils.isEmpty(content) || file == null) {
			throw new ApiException(ErrorConstants.ErrorInvalidArgument.toString());
		}
		try {
			FileUtils.writeStringToFile(file, content);
		} catch (IOException e) {
			throw new ApiException(ErrorConstants.ErrorCreatingOrWritingToFile.toString(), e);
		}

	}
}
