package parsers.json;

/**
 * holds the parameters names in the json string as specified by the server
 * 
 * @author oded herbst
 * 
 */
public class QueryConstants {

	// String parameters
	public static final String NAME = "name";
	public static final String FULL_NAME = "fullName";
	public static final String TYPE = "type";
	public static final String COUNTRY_CODE = "countryCode";
	public static final String IATA_AIRPORT_CODE = "iata_airport_code";

	// Long parameters
	public static final String ID = "_id";
	public static final String LOCATION_ID = "location_id";
	public static final String KEY = "key";

	// Array
	public static final String GEO_POSITION = "geo_position";

	// Double parameters
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String DISTANCE = "distance";

	// Boolean parameters
	public static final String IN_EUROPE = "inEurope";
	public static final String CORE_COUNTRY = "coreCountry";

}
