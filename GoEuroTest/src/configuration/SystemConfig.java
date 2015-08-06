package configuration;

/**
 * This singleton class holds parameters used for the system flow
 * 
 * @author oded herbst
 * 
 */
public class SystemConfig {

	private static String apiPrefix;

	protected SystemConfig() {
	};

	public static void init() {
		apiPrefix = "http://api.goeuro.com/api/v2/position/suggest/en/";
	}

	public static String getApiPrefix() {
		return apiPrefix;
	}

}
