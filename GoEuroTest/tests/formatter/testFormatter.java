package formatter;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import models.LocationResult;

import org.junit.Test;

import formatters.csv.CsvFormatter;
import formatters.csv.LocationFormatter;

public class testFormatter {

	private final String empty_result = "Id,Name,Type,Longitude,Latitude" + System.getProperty("line.separator");
	private final String one_location = "Id,Name,Type,Longitude,Latitude" + System.getProperty("line.separator")
			+ "1,myName,myType,2.2,1.1" + System.getProperty("line.separator");

	@Test
	public void testNoDate() {
		List<LocationResult> locations = new ArrayList<LocationResult>();

		LocationFormatter formatter = new CsvFormatter();
		String formattedString = formatter.formatLocation(locations);
		Assert.assertEquals(empty_result, formattedString);
	}

	@Test
	public void sanity() {
		LocationResult lr = new LocationResult(1L, "myName", "myType", 1.1, 2.2);
		List<LocationResult> locations = new ArrayList<LocationResult>();
		locations.add(lr);

		LocationFormatter formatter = new CsvFormatter();
		String formattedString = formatter.formatLocation(locations);

		Assert.assertEquals(one_location, formattedString);
	}
}
