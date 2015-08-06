package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

import exceptions.ApiException;
import exceptions.ErrorConstants;

public class HttpUtils {

	public static String doGet(String fullUrl) throws ApiException {

		if (StringUtils.isEmpty(fullUrl)) {
			throw new ApiException(ErrorConstants.ErrorInvalidArgument.toString());
		}

		try {

			URL obj = new URL(fullUrl);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();

			if (responseCode != 200) {
				throw new ApiException(ErrorConstants.ErrorInRemoteServer.toString() + "code received for request was " + responseCode);
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			return response.toString();
		} catch (MalformedURLException e) {
			throw new ApiException(ErrorConstants.ErrorInRequestUrl + fullUrl, e);
		} catch (IOException e) {
			throw new ApiException(ErrorConstants.ErrorInRemoteServer.toString(), e);
		}

	}

}
