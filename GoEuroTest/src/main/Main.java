package main;

import java.io.File;
import java.util.List;

import models.LocationResult;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import parsers.json.JsonParser;
import utils.DataSourceUtils;
import utils.HttpUtils;
import utils.Utils;
import configuration.SystemConfig;
import exceptions.ApiException;
import exceptions.ErrorConstants;
import formatters.csv.CsvFormatter;
import formatters.csv.LocationFormatter;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	/**
	 * Main process for go euro query to csv
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			printUsage();
			logger.error(ErrorConstants.ErrorWrongUsage.toString());
			return;
		}

		// Init
		logger.debug("Initiating system");
		SystemConfig.init();

		// Validate input
		String location = args[0];
		if (StringUtils.isEmpty(location)) {
			logger.error(ErrorConstants.ErrorInvalidArgument.toString());
			return;
		}
		logger.debug("Querying location : " + location);

		String jsonResult = null;
		// Make query
		logger.debug("Processing result from server");
		try {
			String fullUrl = Utils.buildFullUrl(location);
			jsonResult = HttpUtils.doGet(fullUrl);

			// Check result
			if (StringUtils.isEmpty(jsonResult)) {
				logger.error(ErrorConstants.ErrorEmptyResult.toString());
				return;
			}

			// Parse result
			JsonParser parser = new JsonParser();
			List<LocationResult> locations = parser.parseGoEuroResult(jsonResult);

			if (locations.isEmpty()) {
				logger.debug("Server answer was empty for current location, exiting");
				return;
			}
			// Create csv
			LocationFormatter formatter = new CsvFormatter();
			String csvString = formatter.formatLocation(locations);

			// Write file
			logger.debug("Writing data to file");
			File file = Utils.generateCsvFilename(location);
			DataSourceUtils.writeFile(csvString, file);

			logger.debug("Process finished with no errors");

		} catch (ApiException e) {
			logger.error("Error - " + e.getMessage());
		}

	}

	public static void printUsage() {
		String usage = "This jar is will create a csv file for a location query to the Go Euro server. Usage example : \"java -jar goEuro.jar amsterdam\"";
		System.out.println(usage);
	}
}
