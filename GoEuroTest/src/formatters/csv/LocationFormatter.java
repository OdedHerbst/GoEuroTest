package formatters.csv;

import java.util.List;

import models.LocationResult;

/**
 * An interface for formating a location list into a desired output
 * 
 * @author oded herbst
 * 
 */
public interface LocationFormatter {

	public String formatLocation(List<LocationResult> locations);

}
