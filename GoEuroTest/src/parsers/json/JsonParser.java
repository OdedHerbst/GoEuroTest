package parsers.json;

import java.util.ArrayList;
import java.util.List;

import models.LocationResult;

import org.json.JSONArray;
import org.json.JSONObject;

import exceptions.ApiException;
import exceptions.ErrorConstants;

public class JsonParser {

	/**
	 * This method takes only the parameters needed for the exercise from the
	 * json object. Implementation is as simple as possible using org.json
	 * package.
	 * 
	 * @param jsonString
	 *            - The un processed json string as returned from the server
	 * @return An array of locations extracted from the json string
	 * @throws ApiException
	 */
	public List<LocationResult> parseGoEuroResult(String jsonString) throws ApiException {

		List<LocationResult> locations = new ArrayList<LocationResult>();
		try {
			JSONArray inputArray = new JSONArray(jsonString);
			for (int i = 0; i < inputArray.length(); i++) {
				JSONObject obj = (JSONObject) inputArray.getJSONObject(i);

				Long id = getLongValue(obj, QueryConstants.ID);
				String type = getStringValue(obj, QueryConstants.TYPE);
				String name = getStringValue(obj, QueryConstants.NAME);

				JSONObject position = (JSONObject) obj.get(QueryConstants.GEO_POSITION);

				Double longitude = getDoubleValue(position, QueryConstants.LONGITUDE);
				Double latitude = getDoubleValue(position, QueryConstants.LATITUDE);

				LocationResult result = new LocationResult(id, name, type, latitude, longitude);
				locations.add(result);

			}

		} catch (NumberFormatException e) {
			throw new ApiException(ErrorConstants.ErrorJsonString.toString(), e);
		} catch (Exception e) {
			throw new ApiException(ErrorConstants.ErrorJsonString.toString(), e);
		}

		return locations;
	}

	private Double getDoubleValue(JSONObject obj, String key) {
		if (obj.isNull(key)) {
			return null;
		}
		double result = obj.getDouble(key);
		return Double.valueOf(result);
	}

	private String getStringValue(JSONObject obj, String key) {
		if (obj.isNull(key)) {
			return null;
		}
		String result = obj.getString(key);
		return result;
	}

	private Long getLongValue(JSONObject obj, String key) {
		if (obj.isNull(key)) {
			return null;
		}
		long result = obj.getLong(key);
		return Long.valueOf(result);
	}
}
