package formatters.csv;

import java.util.List;

import models.LocationResult;

public class CsvFormatter implements LocationFormatter {

	private final char COMMA_DELIMETER = ',';
	// Use this system property in order to make sure this will work on every
	// machine type
	private final String NEW_LINE_SEPERATOR = System.getProperty("line.separator");

	/**
	 * Returns a valid csv String ready to be written to file
	 */
	public String formatLocation(List<LocationResult> locations) {
		StringBuilder sb = new StringBuilder();
		sb.append(getColumnNamesForLocations());

		for (LocationResult lr : locations) {
			sb.append(getLocationLine(lr));
		}
		return sb.toString();
	}

	/**
	 * Creates an entire line of data from a single location result and ends
	 * with new line
	 * 
	 * @param lr
	 * @return
	 */
	private String getLocationLine(LocationResult lr) {
		StringBuilder sb = new StringBuilder();
		sb.append(lr.getId());
		sb.append(COMMA_DELIMETER);
		sb.append(lr.getName());
		sb.append(COMMA_DELIMETER);
		sb.append(lr.getType());
		sb.append(COMMA_DELIMETER);
		sb.append(lr.getLongitude());
		sb.append(COMMA_DELIMETER);
		sb.append(lr.getLatitude());
		sb.append(NEW_LINE_SEPERATOR);

		return sb.toString();
	}

	/**
	 * Creates the title for the csv file and ends with new line
	 * 
	 * @return
	 */
	private String getColumnNamesForLocations() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id");
		sb.append(COMMA_DELIMETER);
		sb.append("Name");
		sb.append(COMMA_DELIMETER);
		sb.append("Type");
		sb.append(COMMA_DELIMETER);
		sb.append("Longitude");
		sb.append(COMMA_DELIMETER);
		sb.append("Latitude");
		sb.append(NEW_LINE_SEPERATOR);

		return sb.toString();
	}

}
