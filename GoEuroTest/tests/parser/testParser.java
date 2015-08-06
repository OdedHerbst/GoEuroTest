package parser;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import models.LocationResult;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import parsers.json.JsonParser;
import exceptions.ApiException;

public class testParser {

	private static String sanityFilename = "/tests/resources/jsonResult.txt";
	private static String nullDataFilename = "/tests/resources/jsonResultNullData.txt";

	@Test
	public void sanity() {
		JsonParser parser = new JsonParser();
		File file = new File(System.getProperty("user.dir") + sanityFilename);
		String jsonString;
		List<LocationResult> result = null;

		try {
			jsonString = FileUtils.readFileToString(file);
			result = parser.parseGoEuroResult(jsonString);
		} catch (IOException e) {
			fail();
		} catch (ApiException e) {
			fail();
		}

		Assert.assertEquals(8, result.size());
	}

	@Test
	public void nullData() {
		JsonParser parser = new JsonParser();
		File file = new File(System.getProperty("user.dir") + nullDataFilename);
		String jsonString;
		List<LocationResult> result = null;

		try {
			jsonString = FileUtils.readFileToString(file);
			result = parser.parseGoEuroResult(jsonString);
		} catch (IOException e) {
			fail();
		} catch (ApiException e) {
			fail();
		}

		Assert.assertEquals(1, result.size());
	}

	@Test
	public void noDataTest() {
		JsonParser parser = new JsonParser();
		List<LocationResult> result = null;
		String jsonString = "[]";
		try {
			result = parser.parseGoEuroResult(jsonString);
		} catch (ApiException e) {
			fail();
		}

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void corruptDataTest() {

		JsonParser parser = new JsonParser();
		List<LocationResult> result = null;
		String jsonString = "notAValidJsonFormat";
		try {
			result = parser.parseGoEuroResult(jsonString);
		} catch (ApiException e) {
			return;
		}
		fail();
	}
}
